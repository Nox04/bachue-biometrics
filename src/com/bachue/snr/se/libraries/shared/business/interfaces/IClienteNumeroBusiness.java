package com.bachue.snr.se.libraries.shared.business.interfaces;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.Local;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Interfaz que define métodos para la capa de negocio de Number Convert
 */
@Local
public interface IClienteNumeroBusiness {

	public String convertToWords(BigInteger number) ;	
	
	public String convertToWordsDollars(BigDecimal number) ;	
	
}
