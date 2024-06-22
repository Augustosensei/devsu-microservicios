package com.devsu.cuenta_service.cuenta.service;

import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.service.plantilla.ICrudService;

public interface IMovimientoService extends ICrudService<Movimiento, Integer> {

	void realizarMovimiento(Movimiento movimiento);

}
