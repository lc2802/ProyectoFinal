package FinalProject.Service;

import FinalProject.Model.Factura;

public interface FacturaService {

    Factura mostarFactura(Long clienteID);

    //List<Factura> mostarFactura(String nombreCliente);

}
