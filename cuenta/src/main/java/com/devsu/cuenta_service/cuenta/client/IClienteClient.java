package com.devsu.cuenta_service.cuenta.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsu.cuenta_service.cuenta.DTO.ClienteDTO;

@FeignClient(name = "cliente-service", url = "http://localhost:8080")
public interface IClienteClient {

	@GetMapping("/api/cliente/{id}")
	ClienteDTO getClienteById(@PathVariable("id") Integer id);

	
	@GetMapping("/api/cliente/{idCliente}/nombre")
    String obtenerNombreCliente(@PathVariable("idCliente") Integer idCliente);
}
