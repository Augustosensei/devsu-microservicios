package com.devsu.persona_service.persona.entities;

import java.time.LocalDate;

import com.devsu.persona_service.persona.enums.GeneroEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
public abstract class Persona {

	protected String nombre;
	protected GeneroEnum genero;
	
	@JsonFormat(pattern = "dd-MM-yyyy")
	protected LocalDate fechaNacimiento;
	protected String identificacion;
	protected String telefono;
	protected String direccion;

}
