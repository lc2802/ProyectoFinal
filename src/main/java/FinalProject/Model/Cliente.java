package FinalProject.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/*
 * Entidad Cliente
 */

@Entity @NoArgsConstructor @ToString @EqualsAndHashCode
public class Cliente {

     // Definición de atributos correspondientes a Cliente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter private Long cliente_id;
    @Setter @Getter private String nombre;
    @Setter @Getter private Integer documento;



    @OneToMany(mappedBy = "cliente")
    @Setter @Getter private List<Carrito> carritos;

    @Setter @Getter @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> factura;


}
