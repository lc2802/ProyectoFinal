package FinalProject;

import FinalProject.Model.Producto;
import FinalProject.managers.CarritoManager;
import FinalProject.managers.ClienteManager;
import FinalProject.managers.ProductoManager;

import java.util.ArrayList;
import java.util.List;


public class Main {

    /*Metodo main, acá se ejecuta el programa y se indican las acciones a realizar,
     dentro del persistence.xml se indicó la propiedad CREATE para que cada vez que se ejecute
     se borren las tablas y se vuelva a probar, esto es para una mejor practicidad al momento de probar, luego se deberia cambiar a UPDATE
     */
    public static void main(String[] args) {

        //Se instancia ProductoManager
        ProductoManager producto = new ProductoManager();
        producto.createProducto("Remeras talle unico", 50, 10);
        producto.createProducto("Jeans corte chino", 20, 20.20);
        producto.createProducto("Gorras Goorin bros", 30, 16);
       
        //Se busca por id luego de crearlos con createProducto

        System.out.println(producto.finByID(2));
        System.out.println(producto.finByNombre("remeras"));

        //se instancia ClienteManager
        ClienteManager cliente = new ClienteManager();

        //Se crea clientes con el metodo createClientes de ClienteManager.

        cliente.createCliente("lucas",43464033);
        cliente.createCliente("marcos",15224364);

        //Se busca los clientes que contengan "lucas" dentro de algun campo nombre de los registros e imprime en consola
        System.out.println(cliente.finByNombre("lucas"));

        //Se buscan todos los clientes y despues se imprime en pantalla.
        System.out.println(cliente.findAllClientes());

        //Se instancia CarritoManager
        CarritoManager carrito = new CarritoManager();

        //acá se agregan los productos a la lista productos
        List<Producto> productos = new ArrayList<>();
        productos.add(producto.finByID(1));
        productos.add(producto.finByID(1));
        productos.add(producto.finByID(2));
        productos.add(producto.finByID(2));
        productos.add(producto.finByID(1));

        //se instancia el metodo de la clase Carrito para agregarlo en el/los registros correspondientes de la BBDD
        carrito.addProductsToCarrito(productos,cliente.finByID(2));

        //se imprimen en consola todos los carritos correspondientes a cliente indicado en el parametro.
        System.out.println(carrito.findCarritosByCliente(cliente.finByID(2)));

    }
}
