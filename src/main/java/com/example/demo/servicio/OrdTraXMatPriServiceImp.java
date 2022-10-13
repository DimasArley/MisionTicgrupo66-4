
package com.example.demo.servicio;

import com.example.demo.domain.OrdenTrabajoXMateriaPrima;
import java.util.Date;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.dao.IOrdenTrabajoXMatPriDAO;
import org.springframework.data.jpa.repository.Query;

@Service
@Slf4j
public class OrdTraXMatPriServiceImp implements OrdenTrabajoXMatPriService{
    
    @Autowired
    private IOrdenTrabajoXMatPriDAO ordenTrabajoXMatPriDao;

    @Override
    public List<OrdenTrabajoXMateriaPrima> listOrdTraXMatPri() {
        
        return (List<OrdenTrabajoXMateriaPrima>) ordenTrabajoXMatPriDao.findAll();
    }

    @Override
    public void saveOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri) {
        
        ordTraXMatPri.setFechaCrea(new Date());
        ordTraXMatPri.setUserCrea("DIMAS LOPEZ");
        ordenTrabajoXMatPriDao.save(ordTraXMatPri);
        log.info("ingreso a guardar ordTraXMatPri");
        
    }

    @Override
    public void deleteOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri) {
        
        ordenTrabajoXMatPriDao.delete(ordTraXMatPri);
    }

    @Override
    public OrdenTrabajoXMateriaPrima findOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri) {
        
        return ordenTrabajoXMatPriDao.findById(ordTraXMatPri.getIdOrdenTrabajoXMatPri()).orElse(ordTraXMatPri);
    }

    @Override
    public void guardarOrdTraXMatPri(Integer materiaPrimaFk, Long ordenTrabajoFK) {
        
        var ordTraXMatPri = new OrdenTrabajoXMateriaPrima();
        ordTraXMatPri.setFechaCrea(new Date());
        ordTraXMatPri.setUserCrea("DIMAS LOPEZ");
        ordTraXMatPri.setIdmateriaPrimaFk(materiaPrimaFk);
        ordTraXMatPri.setIdordenTrabajoFk(ordenTrabajoFK);
        ordenTrabajoXMatPriDao.save(ordTraXMatPri);
    }

      
}
