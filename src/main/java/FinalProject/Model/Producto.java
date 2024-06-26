package FinalProject.Model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

/*
 * Entidad Producto
 */

@Entity
public class Producto {

         // Definición de atributos correspondientes a Producto


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre_producto;
    private Integer stock;
    private double precio;

    @OneToMany(mappedBy = "producto_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Carrito> carritos;

    //Getters y Setter que se usan para poder setear y obtener infomación de los atributos. 
    //Esto es importante ya que sin esto no se puede persistir.

    public Producto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<Carrito> getcarritos() {
        return carritos;
    }

    public void setcarritos(List<Carrito> carritos) {
        this.carritos = carritos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Double.compare(precio, producto.precio) == 0 && Objects.equals(id, producto.id) && Objects.equals(nombre_producto, producto.nombre_producto) && Objects.equals(stock, producto.stock) && Objects.equals(carritos, producto.carritos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre_producto, stock, precio, carritos);
    }

    @Override
    public String toString() {
        return "producto{" +
                "id=" + id +
                ", name='" + nombre_producto + '\'' +
                ", stock=" + stock +
                ", price=" + precio +
                '}';
    }
}
