package com.example.demo.dao;

import com.example.demo.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IRolDAO extends JpaRepository<Rol, Long>{
    
}
