package FinalProject.Service.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.Model.Cliente;
import FinalProject.Repository.ClienteRepository;
import FinalProject.Service.ClienteService;


@Service
public class ClienteServiceImpl implements ClienteService  {

    @Autowired
    ClienteRepository clienteRepository;

    @Override
    public void createCliente(Cliente cliente) {

        if(cliente.getNombre() != null && cliente.getDocumento() != null) clienteRepository.save(cliente);
       
    }

    @Override
    public Cliente findByID(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    /* 
    @Override
    public List<Cliente> findClientesByNombre(String nombreCliente) {
        return clienteRepository.findByName(nombreCliente);
    }
    */

    @Override
    public List<Cliente> findAllClientes() {
       return clienteRepository.findAll();
    }

    @Override
    public void deleteClienteByID(Long id) {
       clienteRepository.deleteById(id);
    }

    @Override
    public Cliente updateCliente(Long id, Cliente updatedCliente) {
        
        Optional<Cliente> cliente = clienteRepository.findById(id);
        if (cliente.isPresent()) {
            Cliente existingCliente = cliente.get();
            existingCliente.setNombre(updatedCliente.getNombre());
            existingCliente.setDocumento(updatedCliente.getDocumento());
            return clienteRepository.save(existingCliente);
        } else {
            //En el caso que no se pueda actualizar el cliente por algun motivo, se lanza excepcion
            throw new RuntimeException("Cliente no encontrado");
        }

    }



}
