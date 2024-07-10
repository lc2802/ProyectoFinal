package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;


@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Long> {

    @Query("SELECT c.totalCarrito FROM Carrito c WHERE c.cliente = :cliente")
    List<Double> findTotalByCliente(Cliente cliente);

    @Query("SELECT c FROM Carrito c WHERE c.cliente = :cliente AND c.producto = :producto")
    List<Carrito> findCarritos(Producto producto, Cliente cliente);

}
