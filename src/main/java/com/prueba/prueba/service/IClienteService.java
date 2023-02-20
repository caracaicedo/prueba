package com.prueba.prueba.service;

import com.prueba.prueba.dto.ClienteDto;

public interface IClienteService {
	
	/**
	 * Metodo para obtener la informacion basica de un cliente
	 * @param tipoDocumento
	 * @param numeroDcumento
	 * @return
	 */
	ClienteDto getCliente(String tipoDocumento,String numeroDcumento);
}
