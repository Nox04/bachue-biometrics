package com.bachue.snr.biometrico.servicios.ws;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IHuellaBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ISesionBusiness;
import com.bachue.snr.biometrico.admon.facade.ejb.stateless.IUsuarioBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;

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
import javax.servlet.ServletContext;

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
    HttpServletRequest req = (HttpServletRequest)mc.get(MessageContext.SERVLET_REQUEST);

    Boolean lb_estado;
    for(HuellaDTO lhd_huella : ahd_huellas) {
      lhd_huella.agregarValoresAuditoria(req);
      iihb_huellaBusiness.enrolarHuella(lhd_huella);
    }

    lb_estado = iihb_huellaBusiness.crearMegaTemplate(ahd_huellas[0]);
    return lb_estado;
  }
}