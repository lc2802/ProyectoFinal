package FinalProject.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.Model.Carrito;
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

    @Override
    public Factura mostarFactura(Long clienteID) {
       
        Cliente cliente = clienteService.finByID(clienteID);

        List<Double> totalList = carritoRepository.findTotalByCliente(cliente);

        Factura factura = factura-    
        Double total = totalList.stream().reduce(0.0, Double::sum);
  
        return ;
  
    }

   

}
