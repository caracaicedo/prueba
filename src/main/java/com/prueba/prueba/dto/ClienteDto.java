package com.prueba.prueba.dto;

import lombok.Data;

@Data
public class ClienteDto {
	
	private String primerNombre;
	private String segundoNombre;
	private String primerApellido;
	private String segundoApellido;
	private Long telefono;
	private String direccion;
	private String ciudadResidencia;
}
