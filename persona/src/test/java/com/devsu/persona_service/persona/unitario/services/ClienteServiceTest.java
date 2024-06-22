package com.devsu.persona_service.persona.unitario.services;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.devsu.persona_service.persona.entities.Cliente;
import com.devsu.persona_service.persona.repository.IClienteRepository;
import com.devsu.persona_service.persona.service.impl.ClienteServiceImpl;

@ExtendWith(MockitoExtension.class)
public class ClienteServiceTest {

	@Mock
	private IClienteRepository clienteRepository;

	@InjectMocks
	private ClienteServiceImpl clienteService;

	private Cliente cliente;

	@BeforeEach
	void setUp() {
		cliente = new Cliente();
		cliente.setIdCliente(1);
		cliente.setNombre("Test Cliente");

	}

	@Test
	void testListarTodo() {
		List<Cliente> listaClientes = Arrays.asList(cliente);
		when(clienteRepository.findAll()).thenReturn(listaClientes);

		List<Cliente> result = clienteService.listarTodo();
		assertThat(result).isNotNull();
		assertThat(result).hasSize(1);
		assertThat(result).containsExactly(cliente);
	}

	@Test
	void testObtenerPorId() {
		when(clienteRepository.findById(1)).thenReturn(Optional.of(cliente));

		Cliente result = clienteService.obtenerPorId(1);
		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(cliente);
	}

	@Test
	void testObtenerPorIdNotFound() {
		when(clienteRepository.findById(1)).thenReturn(Optional.empty());

		Cliente result = clienteService.obtenerPorId(1);
		assertThat(result).isNull();
	}

	@Test
	void testAccionesGuardar() {
		when(clienteRepository.save(any(Cliente.class))).thenReturn(cliente);

		Cliente result = clienteService.acciones(cliente);
		assertThat(result).isNotNull();
		assertThat(result).isEqualTo(cliente);
	}

	@Test
	void testEliminarPorId() {
		doNothing().when(clienteRepository).deleteById(1);

		clienteService.eliminarPorId(1);
		verify(clienteRepository, times(1)).deleteById(1);
	}

}
