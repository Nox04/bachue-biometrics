package com.bachue.snr.se.rs;

import com.bachue.snr.se.libraries.shared.business.interfaces.IBiometriaBusiness;
import com.bachue.snr.se.libraries.shared.business.interfaces.IBiometriaLogBusiness;
import com.bachue.snr.se.libraries.shared.dtos.HuellaDTO;
import com.bachue.snr.se.libraries.shared.dtos.LogDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

@Stateless
@ApplicationPath("/api")
@Path("/biometria")
public class BiometriaRS extends Application {

  @EJB(mappedName = "ejb/BiometriaBusiness")
  IBiometriaBusiness biometriaBusiness;

  @EJB(mappedName = "ejb/BiometriaLogBusiness")
  IBiometriaLogBusiness biometriaLogBusiness;

  @POST
  @Path("/enrolar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response enrolar(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.enrolarHuella(huella);
    return Response.status(200).entity(estado).build();
  }

  @POST
  @Path("/verificar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verificar(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.verificarHuella(huella);
    return Response.status(200).entity(estado).build();
  }

  @POST
  @Path("/log")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registrar(LogDTO log) {
    Boolean estado = biometriaLogBusiness.registrarEvento(log);
    return Response.status(200).entity(estado).build();
  }

  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<>();
    properties.put("jersey.config.server.provider.packages", "com.bachue.snr.se.rs");
    properties.put("jersey.config.server.disableMoxyJson", true);
    return properties;
  }
}
