package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;


import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;
import FinalProject.Model.Producto;


@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Long> {

    @Query("SELECT c.totalCarrito FROM Carrito c WHERE c.cliente = :cliente AND c.entregado = false")
    List<Double> findTotalByCliente(Cliente cliente);

    @Query("SELECT c FROM Carrito c WHERE c.cliente = :cliente AND c.producto = :producto ORDER BY c.dateTime DESC")
    List<Carrito> findCarritos(@Param("producto") Producto producto, @Param("cliente") Cliente cliente, Pageable pageable);

    @Query("SELECT c FROM Carrito c WHERE c.cliente = :cliente")
    List<Carrito> findCarritosByCliente(Cliente cliente);

    @Query("SELECT c FROM Carrito c WHERE c.cliente = :cliente AND c.entregado = false")
    List<Carrito> findCarritosByClienteNoEntregados(Cliente cliente);

}
