package FinalProject.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import FinalProject.Model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente, Long> {

    @Query("SELECT c FROM Cliente c WHERE c.nombre LIKE CONCAT('%', :nombreCliente, '%')")
    List<Cliente> findByName(String nombreCliente);

}
