package com.devsu.persona_service.persona.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devsu.persona_service.persona.entities.Cliente;
import com.devsu.persona_service.persona.repository.IClienteRepository;
import com.devsu.persona_service.persona.service.IClienteService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteServiceImpl implements IClienteService {

	private IClienteRepository clienteRepository;

	public List<Cliente> listarTodo() {

		return clienteRepository.findAll();
	}

	@Override
	public Cliente obtenerPorId(Integer id) {

		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public Cliente acciones(Cliente cliente) {
		return clienteRepository.save(cliente);
	}

	@Override
	public void eliminarPorId(Integer id) {
		clienteRepository.deleteById(id);

	}

	@Override
	public String obtenerNombreCliente(Integer idCliente) {

		Cliente cliente = clienteRepository.findFirstByIdCliente(idCliente);
		String nombre = cliente != null ? cliente.getNombre() : null;

		return nombre;
	}

}
