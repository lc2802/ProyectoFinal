package FinalProject.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Objects;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Factura {

         // Definición de atributos correspondientes a Factura

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long id;
    @Getter @Setter private double total;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter @Setter private Date dateTime;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @PreUpdate
    protected void onUpdate() {
        dateTime = new Date();
    }
}
