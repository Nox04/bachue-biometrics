package com.bachue.snr.se.rs;

import com.bachue.snr.se.libraries.shared.business.interfaces.INumeroBusiness;
import com.bachue.snr.se.libraries.shared.dtos.HuellaDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@Path("/biometria")
public class BiometriaRS {

  @EJB
  INumeroBusiness numeroBusiness;


  @POST
  @Path("/verificacion")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verify(HuellaDTO huella) {
    Boolean estado = usuarioBusiness.crearUsuario(huella);
    return Response.status(200).entity(estado).build();
  }
}
