package FinalProject.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/*
 * Entidad Cliente
 */

@Entity
public class Cliente {

     // Definición de atributos correspondientes a Cliente

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cliente_id;
    private String nombre;
    private Integer documento;

    @Transient
    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;


    @Transient
    @OneToMany(mappedBy = "cliente_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Factura> factura;

    //Getters y Setter que se usan para poder setear y obtener infomación de los atributos. 
    //Esto es importante ya que sin esto no se puede persistir.

    public Cliente() {
    }

    public Integer getId() {
        return cliente_id;
    }

    public void setId(Integer cliente_id) {
        this.cliente_id = cliente_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public List<Carrito> getCarritos() {
        return carritos;
    }

    public void setCarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    public List<Factura> getFactura() {
        return factura;
    }

    public void setFactura(List<Factura> factura) {
        this.factura = factura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(cliente_id, cliente.cliente_id) && Objects.equals(nombre, cliente.nombre) && Objects.equals(documento, cliente.documento) && Objects.equals(carritos, cliente.carritos) && Objects.equals(factura, cliente.factura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cliente_id, nombre, documento, carritos, factura);
    }

    @Override
    public String toString() {
        return "cliente{" +
                "cliente_id=" + cliente_id +
                ", name='" + nombre + '\'' +
                ", documento=" + documento +
                //OJO CON LAS LISTAS!!!
                //", carritos=" + carritos +
                //", facturas=" + facturas +
                '}';
    }
}