package FinalProject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;
    @Getter @Setter private Integer cantidad;
    @Getter @Setter private double precio;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "producto_id") private Producto producto_id;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "cliente_id") private Cliente cliente_id;

    @Getter @Setter private Double total;
}