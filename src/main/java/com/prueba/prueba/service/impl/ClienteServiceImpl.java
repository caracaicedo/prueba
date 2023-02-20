package com.prueba.prueba.service.impl;


import org.springframework.stereotype.Service;

import com.prueba.prueba.dto.ClienteDto;
import com.prueba.prueba.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	/**
	 * Metodo para obtener la informacion basica de un cliente
	 * 
	 * @param tipoDocumento
	 * @param numeroDcumento
	 * @return
	 */
	@Override
	public ClienteDto getCliente(String tipoDocumento, String numeroDcumento) {
		ClienteDto clienteDto=null;
		if(tipoDocumento.equalsIgnoreCase("C") && numeroDcumento.equalsIgnoreCase("23445322")) {
			clienteDto=new ClienteDto();
			clienteDto.setCiudadResidencia("Cali");
			clienteDto.setDireccion("calle 80 # 9-23");
			clienteDto.setPrimerApellido("Perez");
			clienteDto.setSegundoApellido("Arias");
			clienteDto.setPrimerNombre("Juan");
			clienteDto.setSegundoNombre("Camilo");
			clienteDto.setTelefono(3214606754L);
		}
		return clienteDto;
	}
}
