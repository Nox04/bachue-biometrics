package com.bachue.snr.se.libraries.shared.business.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import com.bachue.snr.se.libraries.shared.business.interfaces.IClienteNumeroBusiness;
import com.bachue.snr.se.libraries.shared.business.interfaces.INumeroBusiness;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * EJB de negocio que expone los servicios para convertir los numeros a letras por SOAP 
 */
@Stateless
@LocalBean
public class NumeroBusiness implements INumeroBusiness{

	@EJB
	IClienteNumeroBusiness cliente;
		
	@Override
	public String convertirDolares(BigDecimal number) {
		return cliente.convertToWordsDollars(number);
	}
	
	@Override
	public String convertirPalabra(BigInteger number) {
		return cliente.convertToWords(number);
	}


		
}
