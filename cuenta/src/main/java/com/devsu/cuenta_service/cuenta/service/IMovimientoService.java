package com.devsu.cuenta_service.cuenta.service;

import java.time.LocalDate;
import java.util.List;

import com.devsu.cuenta_service.cuenta.DTO.ReporteMovimientoDTO;
import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.service.plantilla.ICrudService;

public interface IMovimientoService extends ICrudService<Movimiento, Integer> {

	void realizarMovimiento(Movimiento movimiento);

	List<ReporteMovimientoDTO> listarMovimientosPorClienteYFecha(Integer idCliente, LocalDate fechaInicio,
			LocalDate fechaFin);

}
