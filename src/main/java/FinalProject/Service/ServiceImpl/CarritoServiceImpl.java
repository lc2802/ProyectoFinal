package FinalProject.Service.ServiceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;
import FinalProject.Repository.CarritoRepository;
import FinalProject.Service.CarritoService;

@Service
public class CarritoServiceImpl implements CarritoService{

    @Autowired

    CarritoRepository carritoRepository;


    @Override
    public void addToCarrito(Integer cantidad, Producto producto, Cliente cliente) {

        Carrito carrito = new Carrito();
        
        carrito.setCantidad(cantidad);
        carrito.setPrecio(producto.getPrecio());
        carrito.setProducto(producto);
        carrito.setCliente(cliente);

        carritoRepository.save(carrito);
    }

    @Override
    public void addProductsToCarrito(List<Producto> productos, Cliente cliente) {
        try {
            // Map para mantener el conteo de productos por tipo
            Map<Integer, Carrito> carritoMap = new HashMap<>();

            for (Producto producto : productos) {

                // Verifica si el producto ya está en el carrito
                if (carritoMap.containsKey(producto.getId())) {

                    // Si el producto ya está en el carrito incrementa la cantidad
                    Carrito carritoExistente = carritoMap.get(producto.getId());
                    carritoExistente.setCantidad(carritoExistente.getCantidad() + 1);

                } else {
                    // Si el producto no está en el carrito crea un nuevo registro de carrito
                    Carrito carritoNuevo = new Carrito();

                    carritoNuevo.setCantidad(1); // Inicialmente se agrega uno
                    carritoNuevo.setPrecio(producto.getPrecio());
                    carritoNuevo.setProducto(producto);
                    carritoNuevo.setCliente(cliente);
                    carritoNuevo.setEntregado(false);
                    carritoMap.put(producto.getId(), carritoNuevo);
                }
            }
            // Persistir los registros en la base de datos
            for (Carrito carrito : carritoMap.values()) {
                carrito.setTotalCarrito(carrito.getPrecio()*carrito.getCantidad());
                carritoRepository.save(carrito);
            }
        }
         catch (Exception e) {
           System.out.println("No se pudo agregar productos al carrito");
        } 
        
    }

    @Override
    public Map<Producto, Integer> contador(List<Producto> productos) {
            Map<Producto, Integer> elementCountMap = new HashMap<>();

            for (Producto producto : productos) {
                elementCountMap.put(producto, elementCountMap.getOrDefault(producto, 0) + 1);
            }

            return elementCountMap;
        }

    @Override
    public void deleteCarrito(Producto producto, Cliente cliente) {
        Pageable pageable = PageRequest.of(0, 1);
        List<Carrito> carritosToDelete = carritoRepository.findCarritos(producto, cliente, pageable);
        carritoRepository.deleteAll(carritosToDelete);
    }

    @Override
    public List<Carrito> findCarritosByCliente(Cliente cliente) {
        return carritoRepository.findCarritosByCliente(cliente);
    }
}
