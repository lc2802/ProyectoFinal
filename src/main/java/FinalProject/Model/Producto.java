package FinalProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

/*
 * Entidad Producto
 */

@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;
    @Getter @Setter private String nombre_producto;
    @Getter @Setter private Integer stock;
    @Getter @Setter private double precio;

    @OneToMany(mappedBy = "producto")
    @JsonIgnore
    @Setter @Getter private List<Carrito> carritos;

}
