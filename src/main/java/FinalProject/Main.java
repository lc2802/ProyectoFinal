package FinalProject;

import FinalProject.managers.CarritoManager;
import FinalProject.managers.ClienteManager;
import FinalProject.managers.ProductoManager;



public class Main {

    /*Metodo main, acá se ejecuta el programa y
     se indican las acciones a realizar, dentro del persistence.xml se indicó la propiedad CREATE para que cada vez que se ejecute
     se borren las tablas y se vuelva a probar, esto es para una mejor practicidad al momento de probar, luego se deberia cambiar a UPDATE
     */
    public static void main(String[] args) {
        ProductoManager producto = new ProductoManager();
        producto.createProducto("Remeras talle unico", 50, 10);
        producto.createProducto("Jeans corte chino", 20, 20.20);
        producto.createProducto("Gorras Goorin bros", 30, 16);
       
        
        System.out.println(producto.finByID(2));
        System.out.println(producto.finByNombre("remeras")); 

        ClienteManager cliente = new ClienteManager();
        cliente.createCliente("lucas",43464033);
        cliente.createCliente("marcos",15224364);

        System.out.println(cliente.finByNombre("lucas"));
        System.out.println(cliente.findAllClientes());

        CarritoManager carrito = new CarritoManager();
        carrito.addToCarrito(11,producto.finByID(1),cliente.finByID(2));
        carrito.addToCarrito(2,producto.finByID(2),cliente.finByID(1));
        System.out.println(carrito.findCarritosByCliente(cliente.finByID(1)));
        System.out.println(carrito.findCarritosByCliente(cliente.finByID(2)));
        
    }
}
