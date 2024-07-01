package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import FinalProject.Model.Carrito;
import FinalProject.Model.Cliente;


@Repository
public interface CarritoRepository extends JpaRepository <Carrito, Integer> {

    @Query("SELECT id FROM Carrito id WHERE id.cliente_id = :cliente")
     
    List<Carrito> findByNombres(Cliente cliente);

}
