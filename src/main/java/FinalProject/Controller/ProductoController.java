package FinalProject.Controller;

import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;
import FinalProject.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/producto")
public class ProductoController {

    @Autowired
    ProductoService productoService;

    @PostMapping()
    public void postProducto(@RequestBody Producto producto) {
        try {
            productoService.createProducto(producto);
        } catch (Exception exception) {
            System.out.println(exception);
            throw new RuntimeException("CREATE ERROR");
        }
    }

    @GetMapping
    public List<Producto> getAllProducto(){
        try {
            return productoService.findAllProductos();
        } catch (Exception e) {
            throw new RuntimeException("READ ALL ERROR");
        }
    }

    @GetMapping("/{id}")
    public Producto getProductoByID(@PathVariable("id") Long id){
        try {
            return productoService.findID(id);
        } catch (Exception e) {
            throw new RuntimeException("READ ID ERROR");
        }}

    @PutMapping("/{id}")
    public Producto putMethodName(@PathVariable Long id, @RequestBody Producto producto) {

        return productoService.updateProducto(id,producto);

    }


}
