package com.devsu.cuenta_service.cuenta.service.impl;

import org.springframework.stereotype.Service;

import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.repository.IMovimientoRepository;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;
import com.devsu.cuenta_service.cuenta.service.IMovimientoService;
import com.devsu.cuenta_service.cuenta.service.plantilla.CrudServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovimientoServiceImpl extends CrudServiceImpl<Movimiento, Integer> implements IMovimientoService {

	
	private IMovimientoRepository movimientoRepository;

	@Override
	public IRepository<Movimiento, Integer> getRepo() {
		return movimientoRepository;
	}
	
	
	
	
}
