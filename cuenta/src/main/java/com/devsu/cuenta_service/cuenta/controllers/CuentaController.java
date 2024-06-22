package com.devsu.cuenta_service.cuenta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsu.cuenta_service.cuenta.DTO.CuentaDTO;
import com.devsu.cuenta_service.cuenta.entities.Cuenta;
import com.devsu.cuenta_service.cuenta.service.ICuentaService;

@RestController
@RequestMapping("/api/cuenta")

public class CuentaController {

	@Autowired
	private ICuentaService cuentaService;

	@GetMapping
	public ResponseEntity<List<Cuenta>> listarCuenta() {
		List<Cuenta> lista = cuentaService.listarTodo();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<CuentaDTO> obtenerCuentaPorId(@PathVariable final Integer id) {
		// Cuenta entidad = cuentaService.obtenerPorId(id);
		// return new ResponseEntity<>(entidad, HttpStatus.OK);

		CuentaDTO cuentaDTO = cuentaService.getCuentaPorIdCliente(id);
		return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cuenta> guardarCuenta(@RequestBody final Cuenta cuenta) {
		Cuenta entidad = cuentaService.acciones(cuenta);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Cuenta> modificarCuenta(@RequestBody final Cuenta cuenta) {
		Cuenta entidad = cuentaService.acciones(cuenta);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarCuentaPorId(@PathVariable final Integer id) {
		cuentaService.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/detalle/{id}")
	public ResponseEntity<CuentaDTO> obtenerCuentaConCliente(@PathVariable Integer id) {
		CuentaDTO cuentaDTO = cuentaService.getCuentaPorIdCliente(id);
		return new ResponseEntity<>(cuentaDTO, HttpStatus.OK);
	}

}
