
package com.example.demo.dao;

import com.example.demo.domain.OrdenTrabajoXMateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface IOrdenTrabajoXMatPriDAO extends JpaRepository<OrdenTrabajoXMateriaPrima, Long> {
    
    @Modifying
    @Transactional
    @Query(
            value = "DELETE FROM ordentrabajoxmatprima WHERE ordentrabajoxmatprima.ORDENTRABAJOFK LIKE %?1%",
            nativeQuery = true
            )
    void deleteFromOrdenTrabajoFk(Long ordenTrabajoFk);
    
}
