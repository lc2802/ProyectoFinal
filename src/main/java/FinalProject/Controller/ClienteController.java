package FinalProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalProject.Model.Cliente;
import FinalProject.Service.ClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


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
public void findClientes() {
    try {
        clienteService.findAllClientes();
    } catch (Exception e) {
        throw new RuntimeException("READ ALL ERROR");
    }
}

@GetMapping("/{id}")
public void getMethodName(@RequestParam Long id) {
try {
    clienteService.finByID(id);
} catch (Exception e) {
    throw new RuntimeException("READ ID ERROR");
}}


@GetMapping("/{nombre}")
public void findClientesByNombre(String nombre) {
    try {
        clienteService.findClientesByNombre(nombre);
    } catch (Exception e) {
        throw new RuntimeException("READ NAME ERROR");
    }
}





}