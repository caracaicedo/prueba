package com.prueba.prueba;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.prueba.prueba.dto.ClienteDto;
import com.prueba.prueba.service.IClienteService;

public class ClienteRestControllerTest{
	
	@Autowired
	private IClienteService service;
	@Test
	void testDiferentesCasosDeMensajeria() {
		
		ClienteDto clienteDto=null;
			clienteDto=new ClienteDto();
			clienteDto.setCiudadResidencia("Cali");
			clienteDto.setDireccion("calle 80 # 9-23");
			clienteDto.setPrimerApellido("Perez");
			clienteDto.setSegundoApellido("Arias");
			clienteDto.setPrimerNombre("Juan");
			clienteDto.setSegundoNombre("Camilo");
			clienteDto.setTelefono(3214606754L);
	
		
		ClienteDto clinete=	service.getCliente("C", "23445322");
		
		Assert.assertEquals(clienteDto, clinete);
	}
}
