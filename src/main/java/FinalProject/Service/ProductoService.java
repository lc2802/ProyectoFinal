package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Producto;

public interface ProductoService {

    public void createProducto(Producto producto);
    public Producto findByID(Long id);
    public List<Producto> findByNombre(String nombreProducto);
    public List<Producto> findByIDList(List<Long> productosID);

}
