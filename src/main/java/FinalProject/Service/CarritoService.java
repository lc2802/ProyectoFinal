package FinalProject.Service;

import java.util.List;
import java.util.Map;

import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;

public interface CarritoService {

    public void addToCarrito(Integer cantidad, Producto producto, Cliente cliente);
    public void addProductsToCarrito(List<Producto> productos, Cliente cliente);
    public Map<Producto, Integer> contador(List<Producto> productos);
    public Double findCarritosByCliente(Cliente cliente);
}
