
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
import org.springframework.format.annotation.DateTimeFormat;

@Data
@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo implements Serializable{
    
    private static final long serialVersionUID = 1L;
   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDORDENTRABAJO")
    private Long idOrdenTrabajo;
    
    @Column(name = "CLIENTE_FK")
    @NotNull
    private Long clienteFk;
    
    @Column(name = "MATERIA_PRIMA_FK")
    @NotNull
    private Integer materiaPrimaFk;
    
    @Column(name = "FECHA_REGISTRO")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fechaEntrada;
    
    @Column(name = "DESCRIPCION")
    @NotEmpty
    private String descripcion;
    
    @Column(name = "CANT_MATERIA_PRIMA")
    private Integer cantidadMatPri;
    
    @Column(name = "VALOR_MATER_PRIMA")
    private Integer valorMatPri;
    
    @Column(name = "VALOR_MANO_OBRA")
    private Integer valorManoObra;
    
    @Column(name = "HORAS_HOMBRE")
    private Integer horasHombre;
    
    @Column(name = "VALOR_ANTICIPO")
    private Integer valorAnticipo;
    
    @Column(name = "VALOR_SALDO")
    private Integer valorSaldo;
    
    @Column(name = "TOTAL")
    private Integer total;
    
    @Column(name = "FECHA_ENTREGA")
    @DateTimeFormat(pattern= "yyyy-MM-dd")
    private Date fechaEntrega;
    
    @Column(name = "FECHA_CREA")
    private Date fechaCrea;
    
    @Column(name = "USER_CREA")
    private String userCrea;
    
    @Column(name = "FECHA_EDITA")
    private Date fechaEdita;
    
    @Column(name = "USER_EDITA")
    private String userEdita;
    
}
