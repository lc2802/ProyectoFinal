package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;


@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Long> {

    @Query("SELECT id FROM Carrito id WHERE id.cliente_id = :cliente")
     
    List<Carrito> findByNombres(Cliente cliente);

}
