package FinalProject.Service;

import FinalProject.Model.Factura;

public interface FacturaService {

    Factura generarFactura(Long clienteID);

    Factura mostrarFactura(Long clienteID);


}
