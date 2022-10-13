
package com.example.demo.servicio;

import com.example.demo.domain.OrdenTrabajoXMateriaPrima;
import java.util.List;


public interface OrdenTrabajoXMatPriService {
    
    public List<OrdenTrabajoXMateriaPrima> listOrdTraXMatPri();
    
    public void saveOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri);
    
    public void deleteOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri);
    
    public OrdenTrabajoXMateriaPrima findOrdTraXMatPri(OrdenTrabajoXMateriaPrima ordTraXMatPri);
    
    public void guardarOrdTraXMatPri(Integer materiaPrimaFk, Long ordenTrabajoFK);
    
    
}
