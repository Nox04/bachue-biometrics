package com.bachue.snr.biometrico.servicios.rs;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
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

  @EJB(mappedName = "ejb/HuellaBusiness")
  IHuellaBusiness iihb_huellaBusiness;

  @EJB(mappedName = "ejb/LogBusiness")
  ILogBusiness iilb_logBusiness;

  /**
   * Método que recibe la petición HTTP de enrolamiento y la mapea al DTO.
   * @param ahd_huella DTO con la información de la huella.
   * @return respuesta HTTP con el resultado del enrolamiento.
   */
  @POST
  @Path("/huella")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response enrolar(HuellaDTO ahd_huella) {
    Boolean lb_estado = iihb_huellaBusiness.enrolarHuella(ahd_huella);
    return Response.status(200).entity(lb_estado).build();
  }

  /**
   * Método que recibe la petición HTTP de verificación y la mapea al DTO.
   * @param ahd_huella DTO con la información de la huella.
   * @return respuesta HTTP con el resultado de la verificación.
   */
  @POST
  @Path("/verificar")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verificar(HuellaDTO ahd_huella) {
    Boolean lb_estado = iihb_huellaBusiness.verificarHuella(ahd_huella);
    return Response.status(200).entity(lb_estado).build();
  }

  /**
   * Método que recibe la petición HTTP de log y la mapea al DTO.
   * @param ald_log DTO con la información del evento a loguear.
   * @param ahsr_req Request con la información HTTP de la petición recibida.
   * @return respuesta HTTP con el resultado de la operación.
   */
  @POST
  @Path("/log")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response registrar(LogDTO ald_log, @Context HttpServletRequest ahsr_req) {
	  ald_log.agregarValoresAuditoria(ahsr_req);
    Boolean lb_estado = iilb_logBusiness.registrarEvento(ald_log);
    return Response.status(200).entity(lb_estado).build();
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
