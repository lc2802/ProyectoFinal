package FinalProject.managers;

import jakarta.persistence.*;

import java.util.List;

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
