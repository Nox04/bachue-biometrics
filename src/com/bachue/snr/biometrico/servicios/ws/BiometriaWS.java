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
import java.util.ArrayList;

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
   * @param ased_sesion sesion que sera validada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarSesion")
  @WebResult(name = "salidaSesion")
  public SesionDTO consultarSesion(@WebParam(name = "entradaSesion") SesionEntradaDTO ased_sesion) {
    return iisb_sesionBusiness.consultarSesion(ased_sesion.getSesion());
  }


  /**
   * Metodo que recibe la peticion de estadisticas.
   * @param aeed_estadisticas DTO de entrada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarEstadisticas")
  @WebResult(name = "salidaEstadisticas")
  public EstadisticasSalidaDTO consultarEstadisticas(@WebParam(name = "entradaEstadisticas" ) EstadisticasEntradaDTO aeed_estadisticas) {
    return iilb_logBusiness.consultarStats(aeed_estadisticas.getTipo(), aeed_estadisticas.getIdEntidad());
  }


  /**
   * Metodo que enrola las huellas de un usuario previamente creado.
   * @param ahd_huellas DTO con la informacion de las huellas.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "enrolarUsuario")
  @WebResult(name = "salidaResultado")
  public Boolean enrolarUsuario(@WebParam(name = "entradaHuella") HuellaDTO[] ahd_huellas) {

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
   * Metodo que crea un usuario en la base de datos.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "crearUsuario")
  @WebResult(name = "salidaResultado")
  public String crearUsuario(@WebParam(name = "entradaUsuario") UsuarioDTO aud_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.crearUsuario(aud_usuario);
  }

  /**
   * Metodo que actualiza la clave en la base de datos.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "actualizarClave")
  @WebResult(name = "salidaResultado")
  public String actualizarClave(@WebParam(name = "entradaClave") UsuarioDTO aud_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    aud_usuario.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.actualizarClave(aud_usuario);
  }

  /**
   * Metodo que obtiene un usuario de la base de datos.
   * @param aued_usuario id del usuario.
   * @return el estado del usuario.
   */
  @WebMethod(action = "obtenerUsuario")
  @WebResult(name = "salidaResultado")
  public String obtenerUsuario(@WebParam(name = "entradaUsuario") UsuarioEntradaDTO aued_usuario) {
    return iiub_usuarioBusiness.obtenerUsuario(aued_usuario.getIdUsuario());
  }

  /**
   * Metodo que obtiene el tipo de segundo factor de un usuario.
   * @param aued_usuario id del usuario.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "obtenerTipoSegundoFactor")
  @WebResult(name = "salidaResultado")
  public String obtenerTipoSegundoFactor(@WebParam(name = "entradaUsuario") UsuarioEntradaDTO aued_usuario) {
    return iiub_usuarioBusiness.obtenerTipoSegundoFactor(aued_usuario.getIdUsuario());
  }

  /**
   * Metodo obtiene las constantes de la base de datos.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "obtenerConstantes")
  @WebResult(name = "salidaResultado")
  public ArrayList<Constante> obtenerConstantes() {
    return new ArrayList<>(iicb_constanteBusiness.obtenerConstantes());
  }

  /**
   * Metodo que borra la informacion biometrica del usuario.
   * @param bhd_usuario DTO con la informacion del usuario.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "borrarHuellas")
  @WebResult(name = "salidaResultado")
  public String borrarHuellas(@WebParam(name = "entradaUsuario") BorrarHuellasDTO bhd_usuario) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    bhd_usuario.agregarValoresAuditoria(ahsr_req);
    return iihb_huellaBusiness.borrarHuellas(bhd_usuario);
  }

  /**
   * Metodo que verifica un usuario con biometria.
   * @param avd_verificacion DTO con la informacion de la huella.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "verificarUsuario")
  @WebResult(name = "salidaResultado")
  public Boolean verificarUsuario(@WebParam(name = "entradaVerificacion") VerificacionDTO avd_verificacion) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    avd_verificacion.agregarValoresAuditoria(ahsr_req);
    return iihb_huellaBusiness.verificarHuella(avd_verificacion);
  }

  /**
   * Metodo que verifica un usuario con segunda clave.
   * @param acd_clave DTO con la informacion de la clave.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "verificarClave")
  @WebResult(name = "salidaResultado")
  public Boolean verificarClave(@WebParam(name = "entradaClave") ClaveDTO acd_clave) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    acd_clave.agregarValoresAuditoria(ahsr_req);
    return iiub_usuarioBusiness.verificarUsuario(acd_clave);
  }

  /**
   * Metodo que registra un evento en la base de datos.
   * @param ald_log DTO con la informacion del evento a loguear.
   * @return el resultado de la operacion.
   */
  @WebMethod(action = "registrarEvento")
  @WebResult(name = "salidaResultado")
  public Boolean registrarEvento(@WebParam(name = "entradaLog") LogDTO ald_log) {
    MessageContext mc = context.getMessageContext();
    HttpServletRequest ahsr_req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);
    ald_log.agregarValoresAuditoria(ahsr_req);
    return iilb_logBusiness.registrarEvento(ald_log);
  }
}