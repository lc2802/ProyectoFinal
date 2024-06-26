package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long>{

    @Query ("SELECT f FROM Factura f WHERE f.clientes = clientes" )
    List<Factura> findByCliente(List<Cliente> clientes);

}
