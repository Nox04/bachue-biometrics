package com.bachue.snr.biometrico.servicios.rs;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;

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
   * @param ahd_huellas DTO con la informacion de las huellas.
   * @return respuesta HTTP con el resultado del enrolamiento.
   */
  @POST
  @Path("/huella")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response enrolar(HuellaDTO[] ahd_huellas, @Context HttpServletRequest ahsr_req) {
    Boolean lb_estado;
    for(HuellaDTO lhd_huella : ahd_huellas) {
      lhd_huella.agregarValoresAuditoria(ahsr_req);
      iihb_huellaBusiness.enrolarHuella(lhd_huella);
    }

    lb_estado = iihb_huellaBusiness.crearMegaTemplate(ahd_huellas[0]);
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
    String ls_resultado = iiub_usuarioBusiness.crearUsuario(aud_usuario);
    return Response.status(200).entity(ls_resultado).build();
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @PUT
  @Path("/usuario")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response actualizarClave(UsuarioDTO aud_usuario, @Context HttpServletRequest ahsr_req) {
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    String ls_resultado = iiub_usuarioBusiness.actualizarClave(aud_usuario);
    return Response.status(200).entity(ls_resultado).build();
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @DELETE
  @Path("/huella")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response borrarHuellas(UsuarioDTO aud_usuario, @Context HttpServletRequest ahsr_req) {
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    String ls_resultado = iihb_huellaBusiness.borrarHuellas(aud_usuario);
    return Response.status(200).entity(ls_resultado).build();
  }

  /**
   * Metodo que recibe la peticion HTTP de verificacion y la mapea al DTO.
   * @param avd_verificacion DTO con la informacion de la huella.
   * @return respuesta HTTP con el resultado de la verificacion.
   */
  @POST
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public Response verificar(VerificacionDTO avd_verificacion, @Context HttpServletRequest ahsr_req) {
    avd_verificacion.agregarValoresAuditoria(ahsr_req);
    Boolean lb_estado = iihb_huellaBusiness.verificarHuella(avd_verificacion);
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
