package FinalProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Factura {

    // Definición de atributos correspondientes a Factura

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Long id;

    @Getter
    private String Nombre_Cliente;

    @Getter
    @Setter
    private double total;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private LocalDateTime dateTime;

    @ManyToOne
    @JsonIgnore
    @Getter
    @Setter
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @OneToMany
    @Setter
    @Getter
    private List<Carrito> carritos;

    @PrePersist
    @PreUpdate
    protected void onUpdate() {
        dateTime = LocalDateTime.now();
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.Nombre_Cliente = (cliente != null) ? cliente.getNombre() : null; // Establece Nombre_Cliente aquí
    }
}