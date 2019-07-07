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
   * @param log Modelo que será almacenado en la base de datos.
   * @return true si el evento es registrado con éxito.
   */
  Boolean registrarEvento(Log log);
}
