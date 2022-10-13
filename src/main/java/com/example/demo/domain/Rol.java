package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="rol")
public class Rol implements Serializable{
    
    private static final long serialVersionUID = 1l;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDROL")
    private Long idRol;
    
    @Column(name = "CODIGO")
    private String codigo;
    
    @Column(name = "NOMBRE")
    private String nombre;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "ACTIVO")
    private Long activo;
    
    @Column(name = "VER_ROL")
    private Long verRol;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @Column(name = "USER_CREA")
    private String userCrea;
    
    @Column(name = "FECHA_MODIFICA")
    private Date fechaEdita;
    
    @Column(name = "USUARIO_MODIFICA")
    private String userEdita;
    
    
}
