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

import com.devsu.cuenta_service.cuenta.entities.Movimiento;
import com.devsu.cuenta_service.cuenta.service.IMovimientoService;



@RestController
@RequestMapping("/api/movimientos")
public class MovimientoController {



	@Autowired
	private IMovimientoService movimientoService;

	@GetMapping
	public ResponseEntity<List<Movimiento>> listarMovimiento() {
		List<Movimiento> lista = movimientoService.listarTodo();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Movimiento> obtenermMvimientoPorId(@PathVariable final Integer id) {
		Movimiento entidad = movimientoService.obtenerPorId(id);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Movimiento> guardarMovimiento(@RequestBody final Movimiento movimiento) {
		Movimiento entidad = movimientoService.acciones(movimiento);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Movimiento> modificarMovimiento(@RequestBody final Movimiento movimiento) {
		Movimiento entidad = movimientoService.acciones(movimiento);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarMovimientoPorId(@PathVariable final Integer id) {
		movimientoService.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}