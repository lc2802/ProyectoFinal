package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;

@Repository
public interface FacturaRepository extends JpaRepository <Factura, Long>{

    Factura findByCliente(Cliente cliente);

    

}
