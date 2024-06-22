package com.devsu.cuenta_service.cuenta.DTO;

import java.math.BigDecimal;

import com.devsu.cuenta_service.cuenta.enums.TipoCuentaEnum;

import lombok.Data;

@Data
public class CuentaDTO {

	 private Integer idCuenta;
	    private Integer numeroCuenta;
	    private TipoCuentaEnum tipoCuenta;
	    private BigDecimal saldoInicial;
	    private Boolean estado;
	    private ClienteDTO cliente;
	
}
