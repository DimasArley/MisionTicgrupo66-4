package com.example.demo.servicio;

import com.example.demo.domain.Cliente;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.IClienteDAO;
import java.util.Optional;

@Service
@Slf4j
public class ClienteServiceImp implements ClienteService{
    
    @Autowired
    private IClienteDAO clienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Cliente> listClientes() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional
    public void saveCliente(Cliente cliente) {
        cliente.setFechaCrea(new Date());
        cliente.setUserCrea("DIMAS LOPEZ");
        clienteDao.save(cliente);
        log.info("ingreso a guardar cliente");
    }

    @Override
    public void deleteCliente(Cliente cliente) {
        clienteDao.delete(cliente);
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findCliente(Cliente cliente) {
        return clienteDao.findById(cliente.getIdCliente()).orElse(cliente);
    }

    @Override
    public Cliente findById(Long idCliente) {
        
        Optional<Cliente> cliente = clienteDao.findById(idCliente);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
        
        
    }

    
}
