
package com.example.demo.dao;

import com.example.demo.domain.OrdenTrabajo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IOrdenTrabajoDAO extends JpaRepository<OrdenTrabajo, Long>{
    
}
