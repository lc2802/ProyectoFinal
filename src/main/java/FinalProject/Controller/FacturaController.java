package FinalProject.Controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;
import FinalProject.Model.Producto;
import FinalProject.Service.FacturaService;

@RestController
@RequestMapping(path="api/v1/factura")

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
        @ApiResponse(responseCode = "404", description = "No se encontró la ruta"),
        @ApiResponse(responseCode = "500", description = "Error interno")
})

@Tag(name="Factura" , description = "Endpoint para crear facturas para clientes a partir de los carritos que no fueron entregados")

public class FacturaController {
  @Autowired
  FacturaService facturaService; 

@PostMapping("/{clienteID}")
@Operation(summary = "Generar factura", description = "Pasar id de cliente por parametro")

public void generateFacturaByCliente(@PathVariable("clienteID") Long clienteID){
try {
    facturaService.generarFactura(clienteID);
} catch (Exception e) {
    throw new RuntimeException("Error al procesar la solicitud de factura", e);
}
}

@GetMapping("/{clienteID}")
@Operation(summary = "Buscar última factura", description = "Pasar id de cliente por parametro")
public Factura findFacturaByClienteID (@PathVariable ("clienteID") Long clienteID){

    try {
        Factura factura = facturaService.mostrarFactura(clienteID);
        return factura;
    } catch (Exception e) {
        throw new RuntimeException("Error al procesar la solicitud de factura", e);
    
    }
    
}

}