package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Sesion;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de sesion.
 *
 */
@Local
public interface ISesionDAO {
  /**
   * Método que consulta la sesión en la tabla de sesiones.
   * @param as_sesion Sesión que será consultada en la base de datos.
   * @return Sesión consultada en la base de datos.
   */
  Sesion consultarSesion(String as_sesion);
}
