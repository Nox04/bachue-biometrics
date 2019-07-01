package com.bachue.snr.biometria.rs;

import java.math.BigInteger;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.POST;
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
@Path("/biometria")
public class BiometriaRS {

	@EJB
	INumeroBusiness numeroBusiness;
	
	@POST
	@Path("/enrolamiento")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getState() {
		return Response.status(200).entity("En funcionamiento.").build();
	}
	
	@POST
	@Path("/verificacion")
	@Produces(MediaType.APPLICATION_JSON)
	public Response toWords(@PathParam("numero") Integer numero) {
		 String palabras = numeroBusiness.convertirPalabra(BigInteger.valueOf(numero.intValue()));
		return Response.status(200).entity(palabras).build();
	}
}
