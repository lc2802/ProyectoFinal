package FinalProject.Controller;

import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;
import FinalProject.Service.ProductoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/producto")

@ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Respuesta exitosa"),
        @ApiResponse(responseCode = "404", description = "No se encontró la ruta"),
        @ApiResponse(responseCode = "500", description = "Error interno")
})

@Tag(name="Producto" , description = "Endpoint para gestionar productos")
public class ProductoController {

    @Autowired
    ProductoService productoService;




    @PostMapping()
    @Operation(summary = "Nuevo producto", description = "Pasar en el JSON el nombre, stock y precio")

    public void postProducto(@RequestBody Producto producto) {
        try {
            productoService.createProducto(producto);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("CREATE ERROR");
        }
    }

    @GetMapping
    @Operation(summary = "Obtener todos los productos")
    public List<Producto> getAllProducto(){
        try {
            return productoService.findAllProductos();
        } catch (Exception e) {
            throw new RuntimeException("READ ALL ERROR");
        }
    }

    @GetMapping("/{id}")
    @Operation(summary = "Ver producto", description = "Pasar id de producto por parametro")
    public Producto getProductoByID(@PathVariable("id") Long id){
        try {
            return productoService.findID(id);
        } catch (Exception e) {
            throw new RuntimeException("READ ID ERROR");
        }}

    @PutMapping("/{id}")
    @Operation(summary = "Editar producto", description = "Pasar id de producto por parametro y en el JSON pasar nombre y/o stock y/o precio nuevo del producto")
    public Producto putProducto(@PathVariable Long id, @RequestBody Producto producto) {

        return productoService.updateProducto(id,producto);

    }


}
