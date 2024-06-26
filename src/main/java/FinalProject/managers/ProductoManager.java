package FinalProject.managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

import FinalProject.Model.Producto;

//Implementación de Manager, acá se va a aplicar la logica de negocio y los controles de persistencia necesarios.

public class ProductoManager {

    /*
     * Metodo para crear producto
     * primero instancia Manager para comenzar la transaccion y al final lo cierra con un close.Entity
     * En el medio obtiene de los parametros y setea la misma informacion en cada campo correspondiente, por eso es importante el set y get.
     */
    public void createProducto(String nombre, Integer stock, double precio) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Producto producto = new Producto();
            producto.setNombre_producto(nombre);
            producto.setPrecio(precio);
            producto.setStock(stock);
            manager.persist(producto);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }

    /*
     * metodo para buscar por ID de producto
     * en caso de no encontrar producto larga un mensaje
     */
    public Producto finByID(Integer id) {
        EntityManager manager = null;
        Producto producto = null;
        try {
            manager = Manager.get();
            producto = manager.find(Producto.class, id);
            if (producto == null) {            
                System.out.println("No se encontro el producto dentro del catalogo");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
        return producto;
    }

    /*
     * Metodo para buscar todos los productos que contengan dicha palabra pasada por parametro en nombre.
     * Podria servir para agregar a una lista desplegable de resultados en un Front.
     */
    public List<Producto> finByNombre(String nombreProducto) {
        EntityManager manager = null;
        List<Producto> productos = null;
        try {
            manager = Manager.get();
                productos = manager
                    .createQuery("SELECT p FROM Producto p WHERE p.nombre_producto LIKE CONCAT('%', :nombreProducto, '%')", Producto.class) 
                    .setParameter("nombreProducto", nombreProducto)
                    .getResultList();
                    if (productos.isEmpty()) {
                         System.out.println("No se encontro productos con esa relacion");    
                    } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);  
        }
        return productos;
    }  
  }


