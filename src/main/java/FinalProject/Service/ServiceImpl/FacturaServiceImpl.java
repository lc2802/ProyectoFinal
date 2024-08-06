package FinalProject.Service.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import FinalProject.Model.Carrito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;
import FinalProject.Repository.CarritoRepository;
import FinalProject.Repository.FacturaRepository;
import FinalProject.Service.ClienteService;
import FinalProject.Service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    CarritoRepository carritoRepository;
    
    @Autowired
    ClienteService clienteService;



     @Autowired
     FacturaRepository facturaRepository;

    @Override
    public Factura generarFactura(Long clienteID) {
       
        Cliente cliente = clienteService.findByID(clienteID);
        if(cliente != null){  Factura factura = new Factura();

            factura.setCliente(cliente);
    
            List<Carrito> carritosListEntregable = carritoRepository.findCarritosByClienteNoEntregados(cliente);
            factura.setCarritos(carritosListEntregable);
    
            List<Double> totalList = carritoRepository.findTotalByCliente(cliente);
            factura.setTotal(totalList.stream().reduce(0.0, Double::sum));
    
            for (Carrito carrito : carritosListEntregable) {
                carrito.setEntregado(true);
                carritoRepository.save(carrito);
            }
    
            facturaRepository.save(factura);
            return factura;
      }
        return null;
    }

   @Override
public Factura mostrarFactura(Long clienteID) {
    try {   
        Cliente cliente = clienteService.findByID(clienteID);
        Pageable pageable = PageRequest.of(0, 1); //
        List<Factura> facturas = facturaRepository.findLatestFacturaByCliente(cliente, pageable);
        return facturas.isEmpty() ? null : facturas.get(0);
    } catch (NoSuchElementException e) {
        throw new RuntimeException("No se pudo encontrar el cliente con ID: " + clienteID, e);
    } catch (Exception e) {
        throw new RuntimeException("No se pudo encontrar factura asociada al ID del cliente: " + clienteID, e);
    }        
}

}
