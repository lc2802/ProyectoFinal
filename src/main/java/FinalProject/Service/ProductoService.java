package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Producto;

public interface ProductoService {

    public void createProducto(String nombre, Integer stock, double precio);
    public Producto finByID(Integer id);
    public List<Producto> finByNombre(String nombreProducto);

}
