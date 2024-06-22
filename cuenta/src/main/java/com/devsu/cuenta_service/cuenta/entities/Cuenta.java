package com.devsu.cuenta_service.cuenta.entities;

import jakarta.persistence.Entity;

import java.math.BigDecimal;

import org.hibernate.mapping.List;

import com.devsu.cuenta_service.cuenta.enums.TipoCuentaEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cuenta")
@Getter
@Setter
public class Cuenta {

	
	
    @Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name = "id_cuenta")
protected Integer idCuenta;

 private Integer numeroCuenta;
 private TipoCuentaEnum tipoCuenta;
 private BigDecimal saldoInicial;
 private Boolean estado;
 
 
 @Column(name = "cliente_id")
 private Integer clienteId;
	
}
