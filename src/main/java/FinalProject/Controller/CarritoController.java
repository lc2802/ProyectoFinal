package FinalProject.Controller;

import FinalProject.Model.Carrito;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
        @ApiResponse(responseCode = "404", description = "No se encontró la ruta"),
        @ApiResponse(responseCode = "500", description = "Error interno")
})

@Tag(name="Carrito" , description = "Endpoint para generar carritos a partir de un ID de cliente y un arreglo de productos")

public class CarritoController {

    @Autowired
    CarritoService carritoService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    ProductoService productoService;


   
    @PostMapping("/{idcliente}")
    @Operation(summary = "Generar carrito", description = "pasar por parametro el id de cliente y en el cuerpo un ARRAY de id de productos, se repetira el producto como se repita en el ARRAY")
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
  @Operation(summary = "Eliminar carrito", description = "pasar por parametro el id de cliente y en el cuerpo un ARRAY de id de productos a eliminar, se eliminaran todos los productos que estén en el ARRAY")

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

    @GetMapping("/{idcliente}")
    @Operation(summary = "Buscar carrito", description = "pasar por parametro el id de cliente")

    public List <Carrito> getCarritosByCliente(@PathVariable("idcliente") Long idcliente){
        try {
            Cliente cliente = clienteService.findByID(idcliente);
            return carritoService.findCarritosByCliente(cliente);
        } catch (Exception e) {
            throw new RuntimeException("READ ERROR");
        }}
        
    
}
   



    








