package FinalProject.Model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Objects;



@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Factura {

         // Definición de atributos correspondientes a Factura

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Integer id;
    @Getter @Setter private double total;
    @Getter @Setter private LocalDateTime dateTime;

    @ManyToOne
    @Getter @Setter @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;


}
