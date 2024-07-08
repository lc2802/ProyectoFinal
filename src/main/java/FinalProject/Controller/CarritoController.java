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

    @GetMapping()
    public void findCarrotosByCliente(@RequestParam Cliente cliente) {

        try {
            carritoService.findCarritosByCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException("READ CLIENTE ERROR");
        }
    }

   
    @PostMapping("/{idcliente}")
    public void addProductosToCarrito(@PathVariable("idcliente") Long idcliente, @RequestBody List<Long> productosID) {
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
        
        
    
}
   



    








