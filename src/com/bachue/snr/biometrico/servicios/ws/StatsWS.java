package com.bachue.snr.biometrico.servicios.ws;

import com.bachue.snr.biometrico.admon.facade.ejb.stateless.ILogBusiness;

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
@WebService(serviceName = "StatsController")
public class StatsWS {

  @EJB(mappedName = "ejb/LogBusiness")
  ILogBusiness iilb_logBusiness;

  /**
   * Metodo que recibe la peticion de estadisticas.
   * @param as_tipo tipo de stat consultada.
   * @param as_id id de la entidad asociada.
   * @return DTO con la sesion y su estado.
   */
  @WebMethod(action = "consultarStats")
  @WebResult(name = "stats")
  public int consultarStats(@WebParam(name = "tipo" ) String as_tipo, @WebParam(name = "id" ) String as_id) {
    return iilb_logBusiness.consultarStats(as_tipo, as_id);
  }
}
