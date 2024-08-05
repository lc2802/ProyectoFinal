package FinalProject.Controller;

import java.util.List;

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
public class FacturaController {

  @Autowired
  FacturaService facturaService; 
    


@PostMapping("/{clienteID}")
public void generateFacturaByCliente(@PathVariable("clienteID") Long clienteID){
try {
    facturaService.generarFactura(clienteID);
} catch (Exception e) {
    throw new RuntimeException("Error al procesar la solicitud de factura", e);

}
}

@GetMapping("/{clienteID}")
public Factura findFacturaByClienteID (@PathVariable ("clienteID") Long clienteID){

    try {
        Factura factura = facturaService.mostrarFactura(clienteID);
        return factura;
    } catch (Exception e) {
        throw new RuntimeException("Error al procesar la solicitud de factura", e);
    
    }
    
}

}