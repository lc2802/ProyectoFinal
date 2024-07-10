package FinalProject.Service.ServiceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
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
        Factura factura = new Factura();

        List<Double> totalList = carritoRepository.findTotalByCliente(cliente);

        factura.setCliente(cliente);
        factura.setTotal(totalList.stream().reduce(0.0, Double::sum));

        facturaRepository.save(factura);
        return factura;
  
    }

   @Override
public Factura mostrarFactura(Long clienteID) {
    try {   
        Cliente cliente = clienteService.findByID(clienteID);
        Factura factura = facturaRepository.findByCliente(cliente);
        return factura;
    } catch (NoSuchElementException e) {
        throw new RuntimeException("No se pudo encontrar el cliente con ID: " + clienteID, e);
    } catch (Exception e) {
        throw new RuntimeException("No se pudo encontrar factura asociada al ID del cliente: " + clienteID, e);
    }        
}

}
