package FinalProject.Model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

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


    /* 
    @Transient
    @Setter @Getter @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;


    @Transient
    @Setter @Getter @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> factura;

    */

}
