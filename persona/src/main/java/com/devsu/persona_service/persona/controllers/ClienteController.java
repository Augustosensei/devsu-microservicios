package com.devsu.persona_service.persona.controllers;

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

import com.devsu.persona_service.persona.entities.Cliente;
import com.devsu.persona_service.persona.service.IClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {

	@Autowired
	private IClienteService clienteService;

	@GetMapping
	public ResponseEntity<List<Cliente>> listarCliente() {
		List<Cliente> lista = clienteService.listarTodo();
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable final Integer id) {
		Cliente entidad = clienteService.obtenerPorId(id);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Cliente> guardarCliente(@RequestBody final Cliente cliente) {
		Cliente entidad = clienteService.acciones(cliente);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Cliente> modificarCliente(@RequestBody final Cliente cliente) {
		Cliente entidad = clienteService.acciones(cliente);
		return new ResponseEntity<>(entidad, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminarClientePorId(@PathVariable final Integer id) {
		clienteService.eliminarPorId(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping("/{idCliente}/nombre")
	public ResponseEntity<String> obtenerNombreCliente(@PathVariable final Integer idCliente) {
		String nombre = clienteService.obtenerNombreCliente(idCliente);
		return new ResponseEntity<>(nombre, HttpStatus.OK);
	}

}
