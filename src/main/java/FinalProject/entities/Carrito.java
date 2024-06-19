package FinalProject.entities;

import jakarta.persistence.*;
import java.util.Objects;


/*
 * Entidad Carrito donde se hará la  union de las entidades Cliente y Producto
 */
@Entity
public class Carrito {

   

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer cantidad;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto_id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente_id;

    //Getters y Setter que se usan para poder setear y obtener infomación de los atributos. 
    //Esto es importante ya que sin esto no se puede persistir.

    public Carrito() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Producto getproducto_id() {
        return producto_id;
    }

    public void setproducto_id(Producto producto_id) {
        this.producto_id = producto_id;
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
        Carrito carrito = (Carrito) o;
        return Double.compare(precio, carrito.precio) == 0 && Objects.equals(id, carrito.id) && Objects.equals(cantidad, carrito.cantidad) && Objects.equals(producto_id, carrito.producto_id) && Objects.equals(cliente_id, carrito.cliente_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cantidad, precio, producto_id, cliente_id);
    }

    @Override
    public String toString() {
        return "carrito{" +
                "id=" + id +
                ", amount=" + cantidad +
                ", price=" + precio +
                ", producto_id=" + producto_id +
                ", cliente_id=" + cliente_id +
                '}';
    }
}
