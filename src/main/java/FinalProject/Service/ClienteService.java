package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Cliente;

public interface ClienteService {

    public void createCliente(Cliente cliente);
    public Cliente finByID(Integer id);
    public List<Cliente> finByNombre(String nombreCliente);
    public List<Cliente> findAllClientes();


}
