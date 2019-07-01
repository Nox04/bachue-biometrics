package com.bachue.snr.se.rs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bachue.snr.se.libraries.shared.business.interfaces.IUsuarioBusiness;
import com.bachue.snr.se.libraries.shared.dtos.UsuarioDTO;

@Stateless
@ApplicationPath("/api")
@Path("/usuarios")
public class UsuarioRS extends Application {

	@EJB
	IUsuarioBusiness usuarioBusiness;

	@GET
	@Path("/estado")
	@Produces(MediaType.TEXT_PLAIN)
	public Response getState() {
		return Response.status(200).entity("En funcionamiento").build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllUsuarios() {
		List<UsuarioDTO> usuarios = usuarioBusiness.consultarUsuarios();
		return Response.status(200).entity(usuarios).build();
	}

	@GET
	@Path("/{idUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("idUsuario") Integer idUsuario) {
		UsuarioDTO usuario = null;

		try {
			usuario = usuarioBusiness.consultarUsuario(idUsuario);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return Response.status(200).entity(e).build();

		}
		return Response.status(200).entity(usuario).build();
	}

	@GET
	@Path("/nombreUsuario/{nombreUsuario}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsuario(@PathParam("nombreUsuario") String nombreUsuario) {
		UsuarioDTO usuario = null;

		try {
			usuario = usuarioBusiness.consultarUsuario(nombreUsuario);
		}
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return Response.status(200).entity(e).build();

		}
		return Response.status(200).entity(usuario).build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addUsuario(UsuarioDTO user) {
		Boolean estado = usuarioBusiness.crearUsuario(user);
		return Response.status(200).entity(estado).build();
	}

	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("jersey.config.server.provider.packages", "com.smartsoft.ant.rs");
		properties.put("jersey.config.server.disableMoxyJson", true);
		return properties;
	}

}
