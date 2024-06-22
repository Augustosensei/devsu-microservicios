package com.devsu.cuenta_service.cuenta.service;

import java.util.List;

import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.service.plantilla.ICrudService;

public interface IMovimientoService extends ICrudService<Movimiento, Integer>{


	void realizarMovimiento(Movimiento movimiento); 

}
