package com.prueba.prueba.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReponseDto {
	
	private Integer codRespuesta;
	private String DescripcionRespuesta;
	private Object data; 

}
