package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de lógica de negocio de sesiones.
 *
 */
public interface ISesionBusiness {
  /**
   * Método que consulta el estado de la sesión que se está consultando.
   * @param asd_sesion String con la sesión consultada.
   * @return Sesión consultada y su estado.
   */
  SesionDTO consultarSesion(String asd_sesion);
}
