package FinalProject.Service;

import java.util.List;

import FinalProject.Model.Factura;

public interface FacturaService {

    Factura mostarFactura(Long clienteID);

    //List<Factura> mostarFactura(String nombreCliente);

}
