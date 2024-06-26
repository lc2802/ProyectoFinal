package FinalProject.Service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import FinalProject.Model.Cliente;
import FinalProject.Model.Factura;
import FinalProject.Repository.FacturaRepository;
import FinalProject.Service.ClienteService;
import FinalProject.Service.FacturaService;

@Service
public class FacturaServiceImpl implements FacturaService{

    @Autowired
    FacturaRepository facturaRepository;
    
    @Autowired
    ClienteService clienteService;

    @Override
    public List<Factura> mostarFactura(String nombreCliente) {
       
        List<Cliente> clientes = clienteService.findClientesByNombre(nombreCliente);

        return facturaRepository.findByCliente(clientes);
    }

   

}
