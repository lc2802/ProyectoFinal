package FinalProject.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;
import FinalProject.Service.CarritoService;
import FinalProject.Service.ClienteService;
import FinalProject.Service.ProductoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping(path="api/v1/carrito")

public class CarritoController {

    @Autowired
    CarritoService carritoService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;


   
    @PostMapping("/{idcliente}")
    public void addProductosToCarrito(@PathVariable("idcliente") Long idcliente, @RequestBody List<Long> productosID) {
        try {
            Cliente cliente = clienteService.findByID(idcliente);
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

  @DeleteMapping("/{idcliente}")

      public void deleteCarrito(@PathVariable("idcliente") Long idcliente, @RequestBody Long productosID) {
        try {
            Cliente cliente = clienteService.findByID(idcliente);
            Producto producto = productoService.findID(productosID);
    
            if (cliente != null && producto!= null) {     
                carritoService.deleteCarrito(producto, cliente);
            } else {
                throw new RuntimeException("Cliente no encontrado o lista de productos vacía");
            }
        } catch (Exception e) {
            throw new RuntimeException("Error al procesar la solicitud de carrito", e);
        }
    }   
        
    
}
   



    








