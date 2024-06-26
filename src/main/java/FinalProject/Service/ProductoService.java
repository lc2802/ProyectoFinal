package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Producto;

public interface ProductoService {

    public void createProducto(Producto producto);
    public Producto finByID(Integer id);
    public List<Producto> finByNombre(String nombreProducto);

}
