package com.devsu.cuenta_service.cuenta.service;

import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.service.plantilla.ICrudService;

public interface ICuentaService extends ICrudService<Cuenta, Integer> {

	CuentaDTO getCuentaPorIdCliente(Integer idCuenta);

}
