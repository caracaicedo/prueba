package com.prueba.prueba.servicio.ws.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.prueba.dto.ClienteDto;
import com.prueba.prueba.dto.ReponseDto;
import com.prueba.prueba.service.IClienteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = "")
@CrossOrigin(origins = "*")
@Slf4j
public class ClienteRestController {

	@Autowired
	private IClienteService service;

	@GetMapping(value = "/getCliente")
	public ResponseEntity<ReponseDto> consultar(@RequestParam(value="tipoDocumento",required = true) String tipoDocumento,
			@RequestParam(value="numeroDcumento",required = true) String numeroDcumento) {

		try {
			if (!(tipoDocumento.equalsIgnoreCase("C") || tipoDocumento.equalsIgnoreCase("P"))) {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(ReponseDto.builder().codRespuesta(HttpStatus.BAD_REQUEST.value())
								.DescripcionRespuesta("El tipo de documento debe ser C para cedula Y P para pasaporte")
								.build());
			}
			ClienteDto clienteDto = service.getCliente(tipoDocumento, numeroDcumento);
			if (clienteDto == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND)
						.body(ReponseDto.builder().codRespuesta(HttpStatus.NOT_FOUND.value())
								.DescripcionRespuesta("no se encontro informacion para el documento consultado")
								.build());
			}
			return ResponseEntity.status(HttpStatus.OK).body(ReponseDto.builder().codRespuesta(HttpStatus.OK.value())
					.DescripcionRespuesta("Consulta Exitosa").data(clienteDto).build());

		} catch (Exception e) {
			log.error(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body(ReponseDto.builder().codRespuesta(HttpStatus.INTERNAL_SERVER_ERROR.value())
							.DescripcionRespuesta("se presento un error inesperado consultando el servicio").build());
		}
	}
}
