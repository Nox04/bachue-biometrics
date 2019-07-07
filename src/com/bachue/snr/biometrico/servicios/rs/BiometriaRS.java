package com.bachue.snr.biometrico.servicios.rs;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IBiometriaBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IBiometriaLogBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Servicio REST con endpoints para el proyecto de biometría.
 *
 */
@Stateless
@ApplicationPath("/api")
@Path("/biometria")
public class BiometriaRS extends Application {

  @EJB(mappedName = "ejb/BiometriaBusiness")
  IBiometriaBusiness biometriaBusiness;

  @EJB(mappedName = "ejb/BiometriaLogBusiness")
  IBiometriaLogBusiness biometriaLogBusiness;

  /**
   * Método que recibe la petición HTTP de enrolamiento y la mapea al DTO.
   * @param huella DTO con la información de la huella.
   * @return respuesta HTTP con el resultado del enrolamiento
   */
  @POST
  @Path("/enrolar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response enrolar(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.enrolarHuella(huella);
    return Response.status(200).entity(estado).build();
  }

  /**
   * Método que recibe la petición HTTP de verificación y la mapea al DTO.
   * @param huella DTO con la información de la huella.
   * @return respuesta HTTP con el resultado de la verificación.
   */
  @POST
  @Path("/verificar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verificar(HuellaDTO huella) {
    Boolean estado = biometriaBusiness.verificarHuella(huella);
    return Response.status(200).entity(estado).build();
  }

  /**
   * Método que recibe la petición HTTP de log y la mapea al DTO.
   * @param log DTO con la información del evento a loguear.
   * @param req Request con la información HTTP de la petición recibida.
   * @return respuesta HTTP con el resultado de la operación.
   */
  @POST
  @Path("/log")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registrar(LogDTO log, @Context HttpServletRequest req) {
    log.agregarValoresAuditoria(req);
    Boolean estado = biometriaLogBusiness.registrarEvento(log);
    return Response.status(200).entity(estado).build();
  }

  /**
   * Método que mapea las clases con peticiones rest a través de jersey.
   * @return mapa hash con la información de los métodos REST que se mapearán.
   */
  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<>();
    properties.put("jersey.config.server.provider.packages", "com.bachue.snr.biometrico.servicios.rs");
    properties.put("jersey.config.server.disableMoxyJson", true);
    return properties;
  }
}
