package FinalProject.managers;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import FinalProject.entities.Carrito;
import FinalProject.entities.Cliente;
import FinalProject.entities.Producto;

//Implementación de Manager, acá se va a aplicar la logica de negocio y los controles de persistencia necesarios.


public class CarritoManager {
    /*
     * Metodo para crear carritos
     * primero instancia Manager para comenzar la transaccion y al final lo cierra con un close.Entity
     * En el medio obtiene de los parametros y setea la misma informacion en cada campo correspondiente, por eso es importante el set y get.
     */
    public void addToCarrito(Integer cantidad, Producto producto, Cliente cliente) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Carrito carrito = new Carrito();
            carrito.setCantidad(cantidad);
            carrito.setPrecio(producto.getPrecio());
            carrito.setproducto_id(producto);
            carrito.setcliente_id(cliente);
            manager.persist(carrito);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }
    public void addProductsToCarrito(List<Producto> productos, Cliente cliente) {
        EntityManager manager = null;
        EntityTransaction transaction = null;

        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();

            // Map para mantener el conteo de productos por tipo
            Map<Integer, Carrito> carritoMap = new HashMap<>();

            for (Producto producto : productos) {

                // Verifica si el producto ya está en el carrito
                if (carritoMap.containsKey(producto.getId())) {

                    // Si el producto ya está en el carrito incrementa la cantidad
                    Carrito carritoExistente = carritoMap.get(producto.getId());
                    carritoExistente.setCantidad(carritoExistente.getCantidad() + 1);

                } else {
                    // Si el producto no está en el carrito crea un nuevo registro de carrito
                    Carrito carritoNuevo = new Carrito();
                    carritoNuevo.setCantidad(1); // Inicialmente se agrega uno
                    carritoNuevo.setPrecio(producto.getPrecio());
                    carritoNuevo.setproducto_id(producto);
                    carritoNuevo.setcliente_id(cliente);
                    carritoMap.put(producto.getId(), carritoNuevo);
                }
            }
            // Persistir los registros en la base de datos
            for (Carrito carrito : carritoMap.values()) {
                carrito.setTotal(carrito.getPrecio()*carrito.getCantidad());
                manager.persist(carrito);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }


        private static Map<Producto, Integer> contador(List<Producto> productos) {
            Map<Producto, Integer> elementCountMap = new HashMap<>();

            for (Producto producto : productos) {
                elementCountMap.put(producto, elementCountMap.getOrDefault(producto, 0) + 1);
            }

            return elementCountMap;
        }


    /*
     * Metodo para buscar carritos por id de cliente
     */
    public List<Carrito> findCarritosByCliente(Cliente cliente) {
        EntityManager manager = null;
        List<Carrito> carritos = null;
        try {
            manager = Manager.get();
            carritos = manager
                    .createQuery("SELECT id FROM Carrito id WHERE id.cliente_id = :cliente", Carrito.class)
                    .setParameter("cliente", cliente)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
            
        }
        return carritos;
    }
}
