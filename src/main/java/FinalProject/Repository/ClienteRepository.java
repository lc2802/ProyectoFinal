package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import FinalProject.Model.Cliente;

public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE CONCAT('%', :nombreCliente, '%')")
    List<Cliente> findByName(String nombreCliente);

}
