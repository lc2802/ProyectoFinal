package FinalProject.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@RequestMapping(path="api/v1/cliente")

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
        @ApiResponse(responseCode = "404", description = "No se encontró la ruta"),
        @ApiResponse(responseCode = "500", description = "Error interno")
})

@Tag(name="Cliente" , description = "Endpoint para gestionar clientes")

public class ClienteController {

    @Autowired
    private ClienteService clienteService;


    @PostMapping()
    @Operation(summary = "Crear cliente", description = "Solo es necesario pasar en el JSON nombre y documento del cliente")

    public void postCliente(@RequestBody Cliente cliente) {
        try {
            clienteService.createCliente(cliente);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("CREATE ERROR");
        }
    }

    @GetMapping()
    @Operation(summary = "Obtener todos los clientes")

    public List<Cliente> getAll() {
        try {
            return clienteService.findAllClientes();
        } catch (Exception e) {
            throw new RuntimeException("READ ALL ERROR");
        }

    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar cliente", description = "Pasar id de cliente por parametro")

    public Cliente getByID(@PathVariable("id") Long id) {
        try {
            return clienteService.findByID(id);
        } catch (Exception e) {
            throw new RuntimeException("READ ID ERROR");
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar cliente", description = "Pasar id de cliente por parametro")

    public void deleteCliente(@PathVariable("id") Long id) {
        try {
            clienteService.deleteClienteByID(id);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("DELETE CLIENTE ERROR");
        }
    }

    @PutMapping("/{id}")
    @Operation(summary = "Editar cliente", description = "Pasar id de cliente por parametro y dentro del JSON pasar el nuevo nombre y/o documento del cliente")

    public Cliente putCliente(@PathVariable Long id, @RequestBody Cliente cliente) {

        return clienteService.updateCliente(id, cliente);

    }
}





