package com.bachue.snr.se.libraries.shared.business.interfaces;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.Local;
import javax.interceptor.Interceptors;

import com.bachue.snr.se.libraries.interceptors.NumeroInterceptor;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Interfaz que define los metodos para la capa de negocio de numero, es un EJB local
 */
@Local
public interface INumeroBusiness {
	
	@Interceptors(NumeroInterceptor.class)
	public String convertirDolares(BigDecimal number) ;

	@Interceptors(NumeroInterceptor.class)
	public String convertirPalabra(BigInteger number);
	
	
}
