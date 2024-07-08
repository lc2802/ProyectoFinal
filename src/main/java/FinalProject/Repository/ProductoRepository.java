package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import FinalProject.Model.Producto;


@Repository
public interface ProductoRepository extends JpaRepository <Producto, Long> {


    @Query("SELECT p FROM Producto p WHERE p.nombre_producto LIKE CONCAT('%', :nombreProducto, '%')")
    List<Producto> findByNombres(String nombreProducto);

}
