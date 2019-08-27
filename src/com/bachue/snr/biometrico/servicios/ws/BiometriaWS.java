package com.bachue.snr.biometrico.servicios.ws;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.*;
import com.bachue.snr.biometrico.admon.persistence.dto.*;
import com.bachue.snr.biometrico.admon.persistence.model.Constante;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.servlet.http.HttpServletRequest;
import javax.xml.ws.WebServiceContext;
import javax.xml.ws.handler.MessageContext;
import java.util.List;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Servicio SOAP con endpoints para el proyecto de biometria.
 *
 */
@Stateless
@WebService(serviceName = "BiometriaController")
public class BiometriaWS {

  @EJB
  ISesionBusiness iisb_sesionBusiness;

  @EJB
  IHuellaBusiness iihb_huellaBusiness;

  @EJB
  ILogBusiness iilb_logBusiness;

  @EJB
  IUsuarioBusiness iiub_usuarioBusiness;

  @EJB
  IConstanteBusiness iicb_constanteBusiness;

  @Resource
  private WebServiceContext context;


  /**
   * Metodo que recibe la peticion de verificacion de sesion.
   *
   * @param as_sesion sesion que sera validada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarSesion")
  @WebResult(name = "sesion")
  public SesionDTO consultarSesion(@WebParam(name = "sesion") String as_sesion) {
    return iisb_sesionBusiness.consultarSesion(as_sesion);
  }


  /**
   * Metodo que recibe la peticion de estadisticas.
   * @param as_tipo tipo de stat consultada.
   * @param as_id id de la entidad asociada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarEstadisticas")
  @WebResult(name = "estadisticas")
  public int consultarEstadisticas(@WebParam(name = "tipo" ) String as_tipo, @WebParam(name = "id" ) String as_id) {
    return iilb_logBusiness.consultarStats(as_tipo, as_id);
  }


  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param ahd_huellas DTO con la informacion de las huellas.
   * @return respuesta HTTP con el resultado del enrolamiento.
   */
  @WebMethod(action = "enrolarUsuario")
  @WebResult(name = "resultado")
  public Boolean enrolarUsuario(@WebParam(name = "huellas") HuellaDTO[] ahd_huellas) {

    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);

    Boolean lb_estado;
    for(HuellaDTO lhd_huella : ahd_huellas) {
      lhd_huella.agregarValoresAuditoria(ahsr_req);
      iihb_huellaBusiness.enrolarHuella(lhd_huella);
    }

    lb_estado = iihb_huellaBusiness.crearMegaTemplate(ahd_huellas[0]);
    return lb_estado;
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "crearUsuario")
  @WebResult(name = "resultado")
  public String crearUsuario(@WebParam(name = "usuario") UsuarioDTO aud_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.crearUsuario(aud_usuario);
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "actualizarClave")
  @WebResult(name = "resultado")
  public String actualizarClave(@WebParam(name = "usuario") UsuarioDTO aud_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.actualizarClave(aud_usuario);
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param as_id DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "obtenerUsuario")
  @WebResult(name = "resultado")
  public String obtenerUsuario(@WebParam(name = "id") String as_id) {
    return iiub_usuarioBusiness.obtenerUsuario(as_id);
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param as_id DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "obtenerTipoSegundoFactor")
  @WebResult(name = "resultado")
  public String obtenerTipoSegundoFactor(@WebParam(name = "id") String as_id) {
    return iiub_usuarioBusiness.obtenerTipoSegundoFactor(as_id);
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "obtenerTipoSegundoFactor")
  @WebResult(name = "resultado")
  public List<Constante> obtenerConstantes() {
    return iicb_constanteBusiness.obtenerConstantes();
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param bhd_usuario DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "borrarHuellas")
  @WebResult(name = "resultado")
  public String borrarHuellas(@WebParam(name = "usuario") BorrarHuellasDTO bhd_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    bhd_usuario.agregarValoresAuditoria(ahsr_req);
    return iihb_huellaBusiness.borrarHuellas(bhd_usuario);
  }

  /**
   * Metodo que recibe la peticion HTTP de verificacion y la mapea al DTO.
   * @param avd_verificacion DTO con la informacion de la huella.
   * @return respuesta HTTP con el resultado de la verificacion.
   */
  @WebMethod(action = "verificarUsuario")
  @WebResult(name = "resultado")
  public Boolean verificarUsuario(@WebParam(name = "verificacion") VerificacionDTO avd_verificacion) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    avd_verificacion.agregarValoresAuditoria(ahsr_req);
    return iihb_huellaBusiness.verificarHuella(avd_verificacion);
  }

  /**
   * Metodo que recibe la peticion HTTP de enrolamiento y la mapea al DTO.
   * @param acd_clave DTO con la informacion del usuario.
   * @return respuesta HTTP con el resultado de la creación del usuario.
   */
  @WebMethod(action = "verificarClave")
  @WebResult(name = "resultado")
  public Boolean verificarClave(@WebParam(name = "clave") ClaveDTO acd_clave) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    acd_clave.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.verificarUsuario(acd_clave);
  }

  /**
   * Metodo que recibe la peticion HTTP de log y la mapea al DTO.
   * @param ald_log DTO con la informacion del evento a loguear.
   * @return respuesta HTTP con el resultado de la operacion.
   */
  @WebMethod(action = "registrarEvento")
  @WebResult(name = "resultado")
  public Boolean registrarEvento(@WebParam(name = "log") LogDTO ald_log) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    ald_log.agregarValoresAuditoria(ahsr_req);
    return iilb_logBusiness.registrarEvento(ald_log);
  }
}