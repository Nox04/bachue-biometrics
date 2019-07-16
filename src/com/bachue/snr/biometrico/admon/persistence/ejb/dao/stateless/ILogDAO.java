package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Log;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de logs.
 *
 */
@Local
public interface ILogDAO {
  /**
   * Método que registra el evento en la tabla de logs.
   * @param al_log Modelo que será almacenado en la base de datos.
   * @return true si el evento es registrado con éxito.
   */
  Boolean crearEvento(Log al_log);

  /**
   * Método que consulta las stats en la tabla de logs.
   * @param as_tipo Modelo que será almacenado en la base de datos.
   * @param as_id Modelo que será almacenado en la base de datos.
   * @return conteo registrado en la base de datos.
   */
  int consultarStats(String as_tipo, String as_id);
}
