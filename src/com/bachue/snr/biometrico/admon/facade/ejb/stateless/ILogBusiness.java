package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de negocio de logs.
 *
 */
public interface ILogBusiness {
  /**
   * Metodo que envia los datos del evento logueado al DAO para ser almacenado.
   * @param ald_log DTO con la informacion del evento.
   * @return true si el evento es registrado con exito.
   */
  Boolean registrarEvento(LogDTO ald_log);

  /**
   * Metodo que envia los datos de la peticion de stat al DAO para ser consultado.
   * @param as_tipo tipo de peticicion a consultar.
   * @param as_id id de la entidad a consultar.
   * @return int con el conteo de la entidad consultada.
   */
  int consultarStats(String as_tipo, String as_id);
}
