
package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name = "empleado")
public class Empleado implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDEMPLEADO")
    private Long idEmpleado;
    
    @Column(name = "TIPO_IDENTIFICACION")
    @NotEmpty //con esta anotacion indicamos que la cadena correspondiente a este atributo no puede estar vacia, solo sirve para cadenas
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
    
    @Column(name = "DESCRIPCION_EMP")
    private String descripcionEmpleado;
    
    @Column(name = "CARGO")
    private String cargo;
    
    @Column(name = "CATEGORIA")
    private String categoria;
    
    @Column(name = "EMAIL")
    @Email
    private String email;
    
    @Column(name = "TELEFONO")
    private String telefono;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @Column(name = "USER_CREA")
    private String userCrea;
    
    @Column(name = "FECHA_EDITA")
    private Date fechaEdita;
    
    @Column(name = "USER_EDITA")
    private String userEdita;
    
    @OneToMany
    @JoinColumn(name = "EMPLEADO_FK")
    private List<Usuario> usuarios;
    
}
