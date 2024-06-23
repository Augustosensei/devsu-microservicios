package com.devsu.cuenta_service.cuenta.DTO;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.devsu.cuenta_service.cuenta.enums.TipoCuentaEnum;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ReporteMovimientoDTO {

	
	private String nombre;
	private String fecha;
	private Integer numeroCuenta;
	private String tipo;
	private BigDecimal saldoInicial;
	private Boolean estado;
	private BigDecimal movimiento;
	private BigDecimal saldoDisponible;
	
}
