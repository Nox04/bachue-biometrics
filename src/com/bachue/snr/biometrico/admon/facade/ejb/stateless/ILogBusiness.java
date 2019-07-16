package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de lógica de negocio de logs.
 *
 */
public interface ILogBusiness {
  /**
   * Método que envía los datos del evento logueado al DAO para ser almacenado.
   * @param ald_log DTO con la información del evento.
   * @return true si el evento es registrado con éxito.
   */
  Boolean registrarEvento(LogDTO ald_log);

  /**
   * Método que envía los datos de la petición de stat al DAO para ser consultado.
   * @param as_tipo tipo de peticicion a consultar.
   * @param as_id id de la entidad a consultar.
   * @return int con el conteo de la entidad consultada.
   */
  int consultarStats(String as_tipo, String as_id);
}
