package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCLIENTE")
    private Long idCliente;
    
    @Column(name = "TIPO_IDENTIFICACION")
    @NotEmpty
    private String tipoIdentificacion;
    
    @Column(name = "IDENTIFICACION")
    @NotNull
    private String identificacion;
    
    @Column(name = "NOMBRE")
    @NotEmpty
    private String nombre;
    
    @Column(name = "APELLIDO")
    @NotEmpty
    private String apellido;
    
    @Column(name = "CELULAR")
    @NotEmpty
    private String celular;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "DIRECCION")
    private String direccion;
    
    @Column(name = "CIUDAD")
    private String ciudad;
    
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    
    @Column(name = "ORGANIZACION")
    private String organizacion;
    
    @Column(name = "CATEGORIA")
    @NotEmpty
    private String categoria;
    
    @Column(name = "DESCRIPCION")
    private String descripcion;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @Column(name = "USER_CREA")
    private String userCrea;
    
    @Column(name = "FECHA_EDITA")
    private Date fechaEdita;
    
    @Column(name = "USER_EDITA")
    private String userEdita;
    
}
