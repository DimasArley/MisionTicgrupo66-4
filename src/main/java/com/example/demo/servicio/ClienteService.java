package com.example.demo.servicio;

import com.example.demo.domain.Cliente;
import java.util.List;


public interface ClienteService {
    
    public List<Cliente> listClientes();
    
    public void saveCliente(Cliente cliente);
    
    public void deleteCliente(Cliente cliente);
    
    public Cliente findCliente(Cliente cliente);
    
    public Cliente findById(Long idCliente);
    
}
