package com.bachue.snr.se.rs;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bachue.snr.se.libraries.shared.business.interfaces.INumeroBusiness;

/**
 * @author Julian David Marin Rubiano (julian.marin@smartsoft.com.co)
 * Servicio REST que permite el acceso al servicio EJB numeroBusiness
 */
@Stateless
@Path("/numeros")
public class NumberoRS {

	@EJB
	INumeroBusiness numeroBusiness;
	
	@GET
	@Path("/estado")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getState() {
		return Response.status(200).entity("En funcionamiento.").build();
	}
	
	@GET
	@Path("/{numero}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response toWords(@PathParam("numero") Integer numero) {
		 String palabras = numeroBusiness.convertirPalabra(BigInteger.valueOf(numero.intValue()));
		return Response.status(200).entity(palabras).build();
	}
	
	@GET
	@Path("/dolares/{numero}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response toDollars(@PathParam("numero") Double numero) {
		 String palabras = numeroBusiness.convertirDolares(BigDecimal.valueOf(numero.intValue()));
		return Response.status(200).entity(palabras).build();
	}
	
}
