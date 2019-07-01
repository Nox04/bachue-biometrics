package com.bachue.snr.se.libraries.shared.business.impl;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.bachue.snr.se.libraries.shared.business.interfaces.IClienteNumeroBusiness;
import com.dataaccess.webservicesserver.NumberConversion;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Clase que permite acceder al servicio SOAP de http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL a traves de JAR 
 * SOAP de Oracle
 */
@Stateless
@LocalBean
public class ClienteNumeroBusiness implements IClienteNumeroBusiness {
	
	@WebServiceRef(wsdlLocation="http://www.dataaccess.com/webservicesserver/numberconversion.wso?WSDL")
	NumberConversion numberTest;
	
	public String convertToWords(BigInteger number) {		
		return numberTest.getNumberConversionSoap().numberToWords(number);
	}
	
	public String convertToWordsDollars(BigDecimal number) {
		return numberTest.getNumberConversionSoap().numberToDollars(number);
	}

}
