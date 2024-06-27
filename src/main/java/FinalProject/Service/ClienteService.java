package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Cliente;

public interface ClienteService {

    public void createCliente(Cliente cliente);
    public Cliente finByID(Long id);
    public List<Cliente> findClientesByNombre(String nombreCliente);
    public List<Cliente> findAllClientes();


}
