package com.devsu.cuenta_service.cuenta.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.cuenta_service.cuenta.DTO.ClienteDTO;
import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.client.IClienteClient;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.exception.FondosNoEncontradosException;
import com.devsu.cuenta_service.cuenta.repository.ICuentaRepository;
import com.devsu.cuenta_service.cuenta.service.ICuentaService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CuentaServiceImpl implements ICuentaService{
	
	
	private ICuentaRepository cuentaRepository;
	private IClienteClient clienteClient;
	
	public List<Cuenta> listarTodo() {
		return cuentaRepository.findAll();
	}

	@Override
	public CuentaDTO obtenerPorId(Integer idCuenta) {
		//return cuentaRepository.findById(id).orElse(null);
		
	      Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(() -> new FondosNoEncontradosException("Cuenta sin fondos"));
	        
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

	@Override
	public Cuenta acciones(Cuenta cuenta) {
		return cuentaRepository.save(cuenta);
	}

	@Override
	public void eliminarPorId(Integer id) {
		cuentaRepository.findById(id);
		
	}

	@Override
	public CuentaDTO getCuentaPorIdCliente(Integer idCuenta) {
        Cuenta cuenta = cuentaRepository.findById(idCuenta).orElseThrow(() -> new FondosNoEncontradosException("Cuenta sin fondos"));
        
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
