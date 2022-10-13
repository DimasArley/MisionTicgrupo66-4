package com.example.demo.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "ordentrabajoxmatprima")
public class OrdenTrabajoXMateriaPrima implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDORDENTRABAJOXMATPRI")
    private Long idOrdenTrabajoXMatPri;
    
    @Column(name = "ORDENTRABAJOFK")
    @NotNull
    private Long idordenTrabajoFk;
    
    @Column(name = "MATERIAPRIMAFK")
    @NotNull
    private Integer idmateriaPrimaFk;
    
    @Column(name = "FECHACREA")
    private Date fechaCrea;
    
    @Column(name = "USERCREA")
    private String userCrea;
    
    @Column(name = "FECHAEDITA")
    private Date fechaEdita;
    
    @Column(name = "USEREDITA")
    private String userEdita;
    
}
