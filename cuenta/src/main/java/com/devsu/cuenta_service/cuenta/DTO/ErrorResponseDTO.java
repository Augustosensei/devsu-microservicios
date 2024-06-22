package com.devsu.cuenta_service.cuenta.DTO;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ErrorResponseDTO {

	private String error;
	private String mensaje;
}
