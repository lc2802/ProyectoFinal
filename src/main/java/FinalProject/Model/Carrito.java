package FinalProject.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;


    @ManyToOne
    @Getter @Setter @JoinColumn(name = "producto_id") private Producto producto;

    @JsonIgnore
    @ManyToOne
    @Getter @Setter @JoinColumn(name = "cliente_id") private Cliente cliente;

    @Getter @Setter private Integer cantidad;
    @Getter @Setter private double precio;

    @JsonIgnore
    @Transient
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private Factura factura;

    @Temporal(TemporalType.TIMESTAMP)
    @JsonIgnore
    @Getter
    @Setter
    private LocalDateTime dateTime;

    @Getter @Setter private Double totalCarrito;

    @Getter @Setter private Boolean entregado;

     @PrePersist
    @PreUpdate
    protected void onUpdate() {
        dateTime = LocalDateTime.now();
    }

}