package FinalProject.Service;

import java.util.List;
import java.util.Map;

import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;

public interface CarritoService {

    public void addToCarrito(Integer cantidad, Producto producto, Cliente cliente);
    public void addProductsToCarrito(List<Producto> productos, Cliente cliente);
    public Map<Producto, Integer> contador(List<Producto> productos);
    public List<Carrito> findCarritosByCliente(Cliente cliente);
}
