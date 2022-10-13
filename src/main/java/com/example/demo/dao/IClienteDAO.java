package com.example.demo.dao;

import com.example.demo.domain.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClienteDAO extends JpaRepository<Cliente, Long>{
    
}
