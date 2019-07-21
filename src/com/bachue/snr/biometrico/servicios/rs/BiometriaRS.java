package com.bachue.snr.biometrico.servicios.rs;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;

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
 * Nota: Servicio REST con endpoints para el proyecto de biometria.
 *
 */
@Stateless
@ApplicationPath("/api")
@Path("/biometria")
public class BiometriaRS extends Application {

  @EJB
  IHuellaBusiness iihb_huellaBusiness;

  @EJB
  ILogBusiness iilb_logBusiness;

  @EJB
  IUsuarioBusiness iiub_usuarioBusiness;

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param ahd_huella DTO con la informacion de la huella.
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
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @POST
  @Path("/usuario")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response crearUsuario(UsuarioDTO aud_usuario, @Context HttpServletRequest ahsr_req) {
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    Boolean lb_estado = iiub_usuarioBusiness.crearUsuario(aud_usuario);
    return Response.status(200).entity(lb_estado).build();
  }

  /**
   * Metodo que recibe la peticion HTTP de verificacion y la mapea al DTO.
   * @param ahd_huella DTO con la informacion de la huella.
   * @return respuesta HTTP con el resultado de la verificacion.
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verificar(HuellaDTO ahd_huella, @Context HttpServletRequest ahsr_req) {
    ahd_huella.agregarValoresAuditoria(ahsr_req);
    Boolean lb_estado = iihb_huellaBusiness.verificarHuella(ahd_huella);
    return Response.status(200).entity(lb_estado).build();
  }

  /**
   * Metodo que recibe la peticion HTTP de log y la mapea al DTO.
   * @param ald_log DTO con la informacion del evento a loguear.
   * @param ahsr_req Request con la informacion HTTP de la peticion recibida.
   * @return respuesta HTTP con el resultado de la operacion.
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
   * Metodo que mapea las clases con peticiones rest a traves de jersey.
   * @return mapa hash con la informacion de los metodos REST que se mapearan.
   */
  @Override
  public Map<String, Object> getProperties() {
    Map<String, Object> properties = new HashMap<>();
    properties.put("jersey.config.server.provider.packages", "com.bachue.snr.biometrico.servicios.rs");
    properties.put("jersey.config.server.disableMoxyJson", true);
    return properties;
  }
}
