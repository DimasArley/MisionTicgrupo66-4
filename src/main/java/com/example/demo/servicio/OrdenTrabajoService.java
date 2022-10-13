
package com.example.demo.servicio;

import com.example.demo.domain.OrdenTrabajo;
import java.util.List;


public interface OrdenTrabajoService {
    
    public List<OrdenTrabajo> listOrdenTrabajo();
    
    public void saveOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    
    public void deleteOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    
    public OrdenTrabajo findOrdenTrabajo(OrdenTrabajo ordenTrabajo);
    
    void deleteFromOrdenTrabajoFk(Long ordenTrabajoFk);
    
}
