package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Cliente;

public interface ClienteService {

    //Metodo para crear un cliente 
    public void createCliente(Cliente cliente);

    //Metodo para buscar un cliente por ID
    public Cliente findByID(Long id);

    //Metodo para buscar clientes por nombres, nom implementado
    //public List<Cliente> findClientesByNombre(String nombreCliente);

    //Metodo para buscar clientes todos los clientes
    public List<Cliente> findAllClientes();

    //Metodo para eliminar un cliente por ID
    public void deleteClienteByID(Long id);

    //Metodo para editar un cliente que ya se encuentra en la BDD
    public Cliente updateCliente(Long id, Cliente cliente);


}
