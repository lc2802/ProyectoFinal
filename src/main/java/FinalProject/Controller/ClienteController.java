package FinalProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalProject.Model.Cliente;
import FinalProject.Service.ClienteService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
/* 
 *
 * Acá se implementaran los endpoints para las diferentes consultas CRUD del cliente (postman)
 * 
*/
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping(path="api/v1/clientes")
public class ClienteController {

@Autowired
private ClienteService clienteService;


@PostMapping()
public void postMethodName(@RequestBody Cliente cliente) {
    try {
        clienteService.createCliente(cliente);
    } catch( Exception exception) {
        System.out.println(exception);
        throw  new RuntimeException("CREATE ERROR");
    }
}

@GetMapping()
public  List<Cliente> findClientes() {
    try {
        return clienteService.findAllClientes();
    } catch (Exception e) {
        throw new RuntimeException("READ ALL ERROR");
    }
     
}

@GetMapping("/{id}")
public  Cliente getMethodName(@PathVariable("id") Long id){
try {
    return clienteService.finByID(id);
} catch (Exception e) {
    throw new RuntimeException("READ ID ERROR");
}}

@DeleteMapping("/{id}")
    public void deleteCliente(@PathVariable("id") Long id) {
        try {
            clienteService.deleteClienteByID(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("DELETE CLIENTE ERROR");
        }
    }

    @PutMapping("/{id}")
    public Cliente putMethodName(@PathVariable Long id, @RequestBody Cliente cliente) {
        
       Cliente updateCliente= clienteService.updateCliente(id,cliente);
        
        return updateCliente;
        
    }

/*  

**PROXIMA ACTUALIZACION**

@GetMapping("/{nombre}")
public void findClientesByNombre(String nombre) {
    try {
        clienteService.findClientesByNombre(nombre);
    } catch (Exception e) {
        throw new RuntimeException("READ NAME ERROR");
    }

    */
}





