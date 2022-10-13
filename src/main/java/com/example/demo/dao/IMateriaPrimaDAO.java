package com.example.demo.dao;

import com.example.demo.domain.MateriaPrima;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IMateriaPrimaDAO extends JpaRepository<MateriaPrima, Long>{
    
}
