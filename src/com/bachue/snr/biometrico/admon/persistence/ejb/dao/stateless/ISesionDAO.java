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
   * Metodo que consulta la sesion en la tabla de sesiones.
   * @param as_sesion Sesion que sera consultada en la base de datos.
   * @return Sesion consultada en la base de datos.
   */
  Sesion consultarSesion(String as_sesion);

  /**
   * Metodo que crea la sesion en la tabla de sesiones.
   * @param as_sesion Sesion que sera creada en la base de datos.
   * @return resultado de la crecion de la sesion.
   */
  Boolean crearSesion(Sesion as_sesion);
}
