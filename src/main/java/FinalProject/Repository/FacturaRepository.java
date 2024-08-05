package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Pageable;

import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long> {

    @Query("SELECT f FROM Factura f WHERE f.cliente = :cliente ORDER BY f.dateTime DESC")
    List<Factura> findLatestFacturaByCliente(@Param("cliente") Cliente cliente, Pageable pageable);


    

}
