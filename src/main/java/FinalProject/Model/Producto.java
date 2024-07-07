package FinalProject.Model;

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

    @Transient
    @Getter @Setter @OneToMany(mappedBy = "producto_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;


}
