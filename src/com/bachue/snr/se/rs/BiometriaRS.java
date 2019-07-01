package com.bachue.snr.se.rs;

import com.bachue.snr.se.libraries.shared.business.interfaces.IBiometriaBusiness;
import com.bachue.snr.se.libraries.shared.dtos.HuellaDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Stateless
@ApplicationPath("/api")
@Path("/biometria")
public class BiometriaRS extends Application {

  @EJB
  IBiometriaBusiness biometriaBusiness;

  @POST
  @Path("/enrolar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response enroll(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.enrolarHuella(huella);
    return Response.status(200).entity(estado).build();
  }

  @POST
  @Path("/verificar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verify(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.verificarHuella(huella);
    return Response.status(200).entity(estado).build();
  }
}
