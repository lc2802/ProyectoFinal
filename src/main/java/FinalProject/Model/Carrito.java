package FinalProject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    @Getter @Setter private Integer cantidad;
    @Getter @Setter private double precio;

    @ManyToOne
    @JsonManagedReference
    @Getter @Setter @JoinColumn(name = "producto_id") private Producto producto;

    @ManyToOne
    @JsonManagedReference
    @Getter @Setter @JoinColumn(name = "cliente_id") private Cliente cliente;

    @Getter @Setter private Double totalCarrito;
}