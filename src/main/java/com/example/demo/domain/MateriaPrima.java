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
import lombok.Data;

@Data
@Entity
@Table(name = "materia_prima")
public class MateriaPrima implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDMATERIAPRIMA")
    private Long idMateriaPrima;
    
    @Column(name = "NOMBRE")
    @NotEmpty
    private String nombre;
    
    @Column(name = "VALOR")
    private Integer valor;
    
    @Column(name = "UNIDAD_MEDIDA")
    @NotEmpty
    private String unidadMedida;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @Column(name = "USER_CREA")
    private String userCrea;
    
    @Column(name = "FECHA_EDITA")
    private Date fechaEdita;
    
    @Column(name = "USER_EDITA")
    private String userEdita;
    
}
