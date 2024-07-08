package FinalProject.Service.ServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.Model.Producto;
import FinalProject.Repository.ProductoRepository;
import FinalProject.Service.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    ProductoRepository productoRepository;

    @Override
    public void createProducto(Producto producto) {

         if(producto.getNombre_producto() != null && producto.getStock() != null && Double.toString(producto.getPrecio()) != null) productoRepository.save(producto);

    }

    @Override
    public Producto findID(Long id) {

        return productoRepository.findById(id).get();

    }
    

    @Override
    public List<Producto> findByNombre(String nombreProducto) {

        return productoRepository.findByNombres(nombreProducto);


}

    @Override
    public List<Producto> findByIDList(List<Long> productosID) {

        List<Producto> productos = new ArrayList<>();
        
        for (Long productoID : productosID) {
            
            Producto producto = findID(productoID);
            
            productos.add(producto);

        }

        return productos;
    }

    @Override
    public List<Producto> findAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto updateProducto(Long id, Producto newProducto) {
        {

            Optional<Producto> producto = productoRepository.findById(id);
            if (producto.isPresent()) {
                Producto existingProducto = producto.get();
                existingProducto.setNombre_producto(newProducto.getNombre_producto());
                existingProducto.setPrecio(newProducto.getPrecio());
                existingProducto.setStock(newProducto.getStock());
                return productoRepository.save(existingProducto);
            } else {
                //En el caso que no se pueda actualizar el cliente por algun motivo, se lanza excepcion
                throw new RuntimeException("Cliente no encontrado");
            }

        }
    }
}
