package com.devsu.cuenta_service.cuenta.service;

import java.util.List;

import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;



public interface ICuentaService {

	 List<Cuenta> listarTodo();

		CuentaDTO obtenerPorId(final Integer idCuenta);

		Cuenta acciones(final Cuenta cuenta);

		void eliminarPorId(final Integer id);
	
		CuentaDTO getCuentaPorIdCliente(Integer idCuenta);
	
}
