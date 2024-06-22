package com.devsu.cuenta_service.cuenta.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.cuenta_service.cuenta.DTO.ClienteDTO;
import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.client.IClienteClient;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.exception.FondosNoEncontradosException;
import com.devsu.cuenta_service.cuenta.repository.ICuentaRepository;
import com.devsu.cuenta_service.cuenta.repository.plantilla.IRepository;
import com.devsu.cuenta_service.cuenta.service.ICuentaService;
import com.devsu.cuenta_service.cuenta.service.plantilla.CrudServiceImpl;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaServiceImpl extends CrudServiceImpl<Cuenta, Integer> implements ICuentaService {


	private ICuentaRepository cuentaRepository;
	private IClienteClient clienteClient;
	
	@Override
	public IRepository<Cuenta, Integer> getRepo() {
		return cuentaRepository;
	}

	@Override
	public CuentaDTO getCuentaPorIdCliente(Integer idCuenta) {

		Cuenta cuenta = cuentaRepository.findById(idCuenta)
				.orElseThrow(() -> new FondosNoEncontradosException("Cuenta sin fondos"));

		ClienteDTO cliente = clienteClient.getClienteById(cuenta.getClienteId());

		CuentaDTO cuentaDTO = new CuentaDTO();
		cuentaDTO.setIdCuenta(cuenta.getIdCuenta());
		cuentaDTO.setNumeroCuenta(cuenta.getNumeroCuenta());
		cuentaDTO.setTipoCuenta(cuenta.getTipoCuenta());
		cuentaDTO.setSaldoInicial(cuenta.getSaldoInicial());
		cuentaDTO.setEstado(cuenta.getEstado());
		cuentaDTO.setCliente(cliente);

		return cuentaDTO;

	}





}
