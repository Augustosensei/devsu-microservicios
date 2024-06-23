package com.devsu.persona_service.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.devsu.persona_service.persona.entities.Cliente;

public interface IClienteRepository extends JpaRepository<Cliente, Integer> {

	Cliente findFirstByIdCliente(Integer idCliente);




}
