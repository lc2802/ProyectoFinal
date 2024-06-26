package FinalProject.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import FinalProject.Model.Cliente;
import FinalProject.Repository.ClienteRepository;
import FinalProject.Service.ClienteService;

public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void createCliente(Cliente cliente) {

        if(cliente.getNombre() != null && cliente.getDocumento() != null) clienteRepository.save(cliente);
       
    }

    @Override
    public Cliente finByID(Integer id) {
        return finByID(id);
    }

    @Override
    public List<Cliente> finByNombre(String nombreCliente) {
        return clienteRepository.findByName(nombreCliente);
    }

    @Override
    public List<Cliente> findAllClientes() {
       return findAllClientes();
    }

}
