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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping(path="api/v1/Carrito")

public class CarritoController{

@Autowired
CarritoService carritoService;
ClienteService clienteService;
ProductoService productoService;

    @GetMapping()
    public void findCarrotosByCliente(@RequestParam Cliente cliente) {

        try {
            carritoService.findCarritosByCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException("READ CLIENTE ERROR");
        }
    }
    
    //usar los atributos de carrito para el endpoint, es decir, pasar como parametro los atributos de carrito en el controlador.
    /* 

    ** PROXIMA ACTUALIZACION**

   @PostMapping("/AddCarrito")
   public void postMethodName(@RequestBody Long idcliente , @RequestBody List<Long> productosID) {
        try {
            Cliente cliente = clienteService.finByID(idcliente);
            List<Producto> productos = productoService.findByIDList(productosID);
           if(cliente != null && !productos.isEmpty())  carritoService.addProductsToCarrito(productos, cliente);
        } catch (Exception e) {
            throw new RuntimeException("CARRITO ERROR");               
        }       
  */    
   }
   










