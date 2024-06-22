package com.devsu.persona_service.persona.service;

import java.util.List;

import com.devsu.persona_service.persona.entities.Cliente;

public interface IClienteService {

	
	 List<Cliente> listarTodo();

		Cliente obtenerPorId(final Integer id);

		Cliente acciones(final Cliente c);

		void eliminarPorId(final Integer id);
}
