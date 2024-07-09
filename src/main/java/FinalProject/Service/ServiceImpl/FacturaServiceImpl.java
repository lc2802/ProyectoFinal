package FinalProject.Service.ServiceImpl;

import java.util.List;

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
    public Factura mostarFactura(Long clienteID) {
       
        Cliente cliente = clienteService.finByID(clienteID);
        Factura factura = new Factura();

        List<Double> totalList = carritoRepository.findTotalByCliente(cliente);

        factura.setTotal(totalList.stream().reduce(0.0, Double::sum));

        return factura;
  
    }

   

}
