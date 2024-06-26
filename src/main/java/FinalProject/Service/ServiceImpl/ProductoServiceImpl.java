package FinalProject.Service.ServiceImpl;

import java.util.List;

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
    public Producto finByID(Integer id) {

        return finByID(id);

    }
    

    @Override
    public List<Producto> finByNombre(String nombreProducto) {
     
    List<Producto> productos = productoRepository.findByNombres(nombreProducto);          

    return productos;


}
}
