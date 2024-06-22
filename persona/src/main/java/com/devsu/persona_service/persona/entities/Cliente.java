package com.devsu.persona_service.persona.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
	@Table(name = "cliente")
	@Getter
	@Setter
public class Cliente extends Persona{

	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name = "id_cliente")
	   private Integer idCliente;

	    private String clave;
	    private boolean estado;
	
	
}
