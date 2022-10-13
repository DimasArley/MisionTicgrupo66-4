package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="usuario")
public class Usuario implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDUSUARIO")
    private Long idUsuario;
    
    @OneToOne
    @JoinColumn(name = "EMPLEADO_FK", referencedColumnName = "IDEMPLEADO")
    private Empleado empleadoFk;
    
    @Column(name = "USERNAME")
    private String username;
    
    @Column(name = "PASSWORD")
    private String password;
    
    @Column(name = "ACTIVO")
    private int activo;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @OneToMany
    @JoinColumn(name = "IDUSUARIO")
    private List<Rol> roles;
    
    
}
