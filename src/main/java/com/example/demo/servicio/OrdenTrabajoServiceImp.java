
package com.example.demo.servicio;

import com.example.demo.domain.OrdenTrabajo;
import java.util.Date;

import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.demo.dao.IOrdenTrabajoDAO;
import com.example.demo.dao.IOrdenTrabajoXMatPriDAO;

@Service
@Slf4j
public class OrdenTrabajoServiceImp implements OrdenTrabajoService{
    
    @Autowired
    private IOrdenTrabajoDAO ordenTrabajoDao;
    
    @Autowired 
    private IOrdenTrabajoXMatPriDAO ordenTrabajoXMatPriDAO;

    @Override
    @Transactional(readOnly = true)
    public List<OrdenTrabajo> listOrdenTrabajo() {
        
        return (List<OrdenTrabajo>) ordenTrabajoDao.findAll();
    }

    @Override
    public void saveOrdenTrabajo(OrdenTrabajo ordenTrabajo) {

        ordenTrabajo.setDescripcion(ordenTrabajo.getDescripcion().toUpperCase());
        ordenTrabajo.setFechaCrea(new Date());
        ordenTrabajo.setUserCrea("DIMAS LOPEZ");
        ordenTrabajo.setTotal(ordenTrabajo.getValorAnticipo() + ordenTrabajo.getValorManoObra() + ordenTrabajo.getValorMatPri());
        ordenTrabajo.setValorSaldo(ordenTrabajo.getTotal() - (ordenTrabajo.getValorAnticipo() + ordenTrabajo.getValorManoObra() + ordenTrabajo.getValorMatPri()));
        ordenTrabajoDao.save(ordenTrabajo);
        log.info("ingreso a guardar orden trabajo");
    }

    @Override
    public void deleteOrdenTrabajo(OrdenTrabajo ordenTrabajo) {

        ordenTrabajoDao.delete(ordenTrabajo);
    }

    @Override
    public OrdenTrabajo findOrdenTrabajo(OrdenTrabajo ordenTrabajo) {

        return ordenTrabajoDao.findById(ordenTrabajo.getIdOrdenTrabajo()).orElse(ordenTrabajo);
    }

    @Override
    public void deleteFromOrdenTrabajoFk(Long ordenTrabajoFk) {
    
            ordenTrabajoXMatPriDAO.deleteFromOrdenTrabajoFk(ordenTrabajoFk);
    }
    
}
