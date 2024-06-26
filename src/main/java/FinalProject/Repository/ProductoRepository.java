package FinalProject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import FinalProject.Model.Producto;

public interface ProductoRepository extends JpaRepository <Producto, Long> {

}
