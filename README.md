

## CONFIGURACION ##

Para la primera configuración necesita tener instalado mysql, se puede descargar del siguiente link: https://mvnrepository.com/artifact/com.mysql/mysql-connector-j/8.3.0

Tambien debera tener actualizado a una versión JAVA 17, https://www.oracle.com/ar/java/technologies/downloads/.

Para probar puede utilizar POSTMAN https://www.postman.com/downloads/

Tambien puede probar la versión documentada de SWAGGER en el puerto http://localhost:8080/swagger-ui/index.html#/ una vez haya sido levantado el proyecto desde "MainApplication.java"

## ESTRUCTURA ##

La estructura de este proyecto es de capas, cada una cuple una funcion. 

Controlador: el controlador se encarga de los ENDPOINTS y de enviar respuestas desde el servidor.

Servicio: es una interfaz utilizada para luego implementar todos los metodos contenidos en esta. Esto es muy util para mantener orden y modularidad en el codigo.

ServicioIMPL: dentro de esta clase se implementan los servicios y la logica de negocio de la aplicación.

Repositorio: el respositorio se encarga de gestionar las consultas a la BDD.

Entidad: en esta clase se mapean las tablas de la BDD. 



## CLIENTE ##

El modulo clientes tiene 5 ENDPOINTS, dos son los GET (getAll y getByID), postCliente para crear un cliente, deleteCliente que es para eliminar uno y por ultimo putCliente que es para actualizar un cliente.
En el getAll no se solicitan parametros ya que no son necesarios y en postCliente se solicitara el JSON con los datos del nuevo cliente. En getByID, deleteCliente y putCliente si se solicita ID de cliente en la URL y ademas en el putCliente se solicita el JSON con los datos a editar del cliente.


## PRODUCTO ## 

El modulo producto hay 4 ENDPOINTS, getAllProducto que no necesita parametro, postProducto se solicitara el JSON con los datos del nuevo producto, getProductoByID que solicita el ID respectivamente y putProducto que solicita ID y el JSON con las modificaciones nuevas.


## CARRITO ##

El modulo carrito tiene 3 ENDPOINTS, getCarritosByCliente, addProductosToCarrito y deleteCarrito.
Ambos piden como parametro el ID del cliente en la URL y ademas addProductosToCarrito solicita una lista con los productos a agregar. Dependiendo de cuantas veces se repita el producto, será la cantidad que se agregará de ese producto al carrito.
deleteCarrito pide el id del producto a eliminar del carrito. (Se eliminara al último registro entre el ID del cliente y el ID del producto en la BDD) 

## FACTURA ##

El modulo factura tiene 2 ENDPOINTS, generateFacturaByCliente y findFacturaByClienteID.
De vuelta ambos piden en la URL el ID del cliente. La diferencia entre ellos es que el primero genera la factura y el segundo la muestra cuando sea necesario.
