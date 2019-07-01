package com.bachue.snr.se.primeFacets;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.bachue.snr.se.libraries.shared.business.interfaces.INumeroBusiness;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Bean JSF para gestionar ciclo de vida del convertidor numero 
 */
@ManagedBean(name="numero")
@ViewScoped
public class BeanNumero {

	@EJB
	INumeroBusiness numeroBusiness;

	private String palabra = "0";
	private String dolares = "0";
	
	public String getDolares() {
		return dolares;
	}

	public String getPalabra() {
		return palabra;
	}

	public void setDolares(String dolares) {
		this.dolares = numeroBusiness.convertirDolares(new BigDecimal(dolares));
	}
	
	public void setPalabra(String resultWords) {
		BigInteger bi = BigInteger.valueOf(Integer.parseInt(resultWords));
		String value = numeroBusiness.convertirPalabra(bi);
		this.palabra = value;
	}

}
