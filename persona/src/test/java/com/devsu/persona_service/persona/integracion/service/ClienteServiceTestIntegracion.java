package com.devsu.persona_service.persona.integracion.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.devsu.persona_service.persona.entities.Cliente;
import com.devsu.persona_service.persona.enums.GeneroEnum;
import com.devsu.persona_service.persona.service.impl.ClienteServiceImpl;

@SpringBootTest
public class ClienteServiceTestIntegracion {

	@Autowired
	private ClienteServiceImpl clienteService;

	@Test
	public void testGuardarCliente() {
		Cliente cliente = new Cliente();
		cliente.setNombre("Test Cliente");
		cliente.setClave("123");
		cliente.setGenero(GeneroEnum.Femenino);
		cliente.setEstado(true);

		Cliente clienteGuardado = clienteService.acciones(cliente);

		assertThat(clienteGuardado).isNotNull();
		assertThat(clienteGuardado.getClave()).isEqualTo("123");
	}

}
