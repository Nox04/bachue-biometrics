package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de negocio de sesiones.
 *
 */
public interface ISesionBusiness {
  /**
   * Metodo que consulta el estado de la sesion que se esta consultando.
   * @param asd_sesion String con la sesion consultada.
   * @return Sesion consultada y su estado.
   */
  SesionDTO consultarSesion(String asd_sesion);
}
