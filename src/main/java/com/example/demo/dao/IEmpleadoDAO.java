
package com.example.demo.dao;

import com.example.demo.domain.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmpleadoDAO extends JpaRepository<Empleado, Long>{
    
}
