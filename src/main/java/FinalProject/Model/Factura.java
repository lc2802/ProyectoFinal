package FinalProject.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;


/*
 * Entidad Factura
 */

@Entity
public class Factura {

         // Definición de atributos correspondientes a Factura

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private double total;
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;

    public Factura() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Cliente getcliente_id() {
        return cliente_id;
    }

    public void setcliente_id(Cliente cliente_id) {
        this.cliente_id = cliente_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Factura factura = (Factura) o;
        return Double.compare(total, factura.total) == 0 && Objects.equals(id, factura.id) && Objects.equals(dateTime, factura.dateTime) && Objects.equals(cliente_id, factura.cliente_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, total, dateTime, cliente_id);
    }

    @Override
    public String toString() {
        return "factura{" +
                "cliente_id=" + cliente_id +
                ", dateTime=" + dateTime +
                ", total=" + total +
                ", id=" + id +
                '}';
    }
}
