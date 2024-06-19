package FinalProject.managers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

import FinalProject.entities.Cliente;

//Implementación de Manager, acá se va a aplicar la logica de negocio y los controles de persistencia necesarios.

public class ClienteManager {
    /*
     * Metodo para crear clientes
     * primero instancia Manager para comenzar la transaccion y al final lo cierra con un close.Entity
     * En el medio obtiene de los parametros y setea la misma informacion en cada campo correspondiente, por eso es importante el set y get.
     */
    public void createCliente(String nombre, Integer documento) {
        EntityManager manager = null;
        EntityTransaction transaction;
        try {
            manager = Manager.get();
            transaction = manager.getTransaction();
            transaction.begin();
            Cliente cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setDocumento(documento);
            manager.persist(cliente);
            transaction.commit();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
        }
    }

     /*
     * metodo para buscar por ID de Cliente
     * en caso de no encontrar producto larga un mensaje
     */

    public Cliente finByID(Integer id) {
        EntityManager manager = null;
        Cliente cliente = null;
        try {
            manager = Manager.get();
            cliente = manager.find(Cliente.class, id);
            if (cliente == null) {    
             System.out.println("No se encontró cliente con ese ID");
            }        
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);
           
        }
        return cliente;
    }

    /*
     * Metodo para buscar todos los clientes que contengan dicha palabra pasada por parametro en nombre.
     * Podria servir para agregar a una lista desplegable de resultados en un Front.
     */
    
     public List<Cliente> finByNombre(String nombreCliente) {
        EntityManager manager = null;
        List<Cliente> clientes = null;
        try {
            manager = Manager.get();
                clientes = manager
                    .createQuery("SELECT c FROM Cliente c WHERE c.nombre LIKE CONCAT('%', :nombreCliente, '%')", Cliente.class) 
                    .setParameter("nombreCliente", nombreCliente)
                    .getResultList();
                    if (clientes.isEmpty()) {
                         System.out.println("No se encontro clientes con esa relacion");    
                    } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);  
        }
        return clientes;
    }  
  
    //Este metodo busca todos los clientes existentes.

    public List<Cliente> findAllClientes() {
        EntityManager manager = null;
        List<Cliente> clientes = null;
        try {
            manager = Manager.get();
                clientes = manager
                    .createQuery("SELECT c FROM Cliente c", Cliente.class) 
                    .getResultList();
                    if (clientes.isEmpty()) {
                         System.out.println("No se encontro clientes");    
                    } 
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            Manager.closeEntity(manager);  
        }
        return clientes;  
    }
}