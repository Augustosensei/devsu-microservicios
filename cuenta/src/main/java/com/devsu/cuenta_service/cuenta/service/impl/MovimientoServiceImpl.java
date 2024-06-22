package com.devsu.cuenta_service.cuenta.service.impl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.exception.FondosNoEncontradosException;
import com.devsu.cuenta_service.cuenta.repository.ICuentaRepository;
import com.devsu.cuenta_service.cuenta.repository.IMovimientoRepository;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;
import com.devsu.cuenta_service.cuenta.service.ICuentaService;
import com.devsu.cuenta_service.cuenta.service.IMovimientoService;
import com.devsu.cuenta_service.cuenta.service.plantilla.CrudServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MovimientoServiceImpl extends CrudServiceImpl<Movimiento, Integer> implements IMovimientoService {

	
	private IMovimientoRepository movimientoRepository;
	private ICuentaService cuentaService;

	@Override
	public IRepository<Movimiento, Integer> getRepo() {
		return movimientoRepository;
	}

	@Override
	public void realizarMovimiento(Movimiento movimiento) {


		 Cuenta cuenta = cuentaService.obtenerPorId(movimiento.getCuenta().getIdCuenta());

		    if (cuenta.getIdCuenta() == null) {
		        throw new IllegalArgumentException("La cuenta debe tener un ID válido antes de asociarla a un movimiento.");
		    }
		    
		    

		    BigDecimal saldoInicial = cuenta.getSaldoInicial() != null ? cuenta.getSaldoInicial() : BigDecimal.ZERO;
		    BigDecimal nuevoSaldoCuenta = saldoInicial.add(movimiento.getValor());
		    
		    if ( nuevoSaldoCuenta.compareTo(BigDecimal.ZERO) < 0) {
		        throw new FondosNoEncontradosException("Saldo no disponible.");
		    }
		    
		    cuenta.setSaldoInicial(nuevoSaldoCuenta);

		   
		    cuentaService.acciones(cuenta);

		    
		
		    LocalDateTime fechaActual = LocalDateTime.now();
		    
		    movimiento.setFecha(fechaActual);
		    movimiento.setSaldo(nuevoSaldoCuenta);
		    movimientoRepository.save(movimiento);
		

		
	}
	
	
	
	
}
