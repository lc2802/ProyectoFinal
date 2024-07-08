package FinalProject.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;
import FinalProject.Model.Producto;
import FinalProject.Service.FacturaService;

@RestController
public class FacturaController {

  @Autowired
  FacturaService facturaService; 
    
/* 
    @PostMapping
    public void addCarritoToFactura(@PathVariable("idcliente") Long idcliente) {
        try {
            Cliente cliente = clienteService.finByID(idcliente);
            List<Producto> productos = productoService.findByIDList(productosID);
    
            if (cliente != null && !productos.isEmpty()) {     
                carritoService.addProductsToCarrito(productos, cliente);
            } else {
                throw new RuntimeException("Cliente no encontrado o lista de productos vacía");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la solicitud de carrito", e);
        }
    }
    
*/

@GetMapping("/{clienteID}")
public void findFacturaByCliente(@PathVariable("clienteID") Long clienteID){

try {
    facturaService.mostarFactura(clienteID);
} catch (Exception e) {
    throw new RuntimeException("Error al procesar la solicitud de carrito", e);


}

}
}