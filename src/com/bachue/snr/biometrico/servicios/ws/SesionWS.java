package com.bachue.snr.biometrico.servicios.ws;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ISesionBusiness;
import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Servicio SOAP con endpoints para el proyecto de biometria.
 *
 */
@Stateless
@WebService(serviceName = "SesionController")
public class SesionWS {

  @EJB(mappedName = "ejb/SesionBusiness")
  ISesionBusiness iisb_sesionBusiness;

  /**
   * Metodo que recibe la peticion de verificacion de sesion.
   * @param as_sesion sesion que sera validada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarSesion")
  @WebResult(name = "sesion")
  public SesionDTO consultarSesion(@WebParam(name = "sesion" ) String as_sesion) {
    return iisb_sesionBusiness.consultarSesion(as_sesion);
  }
}
