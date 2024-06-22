package com.devsu.persona_service.persona.entities;

import com.devsu.persona_service.persona.enums.GeneroEnum;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona {

	protected String nombre;
	protected GeneroEnum genero;
	protected Integer edad; // fecha nacimiento
	protected String identificacion;
	protected String telefono;
	protected String direccion;

}
