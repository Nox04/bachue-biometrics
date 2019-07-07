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
   * @param log DTO con la información del evento.
   * @return true si el evento es registrado con éxito.
   */
  Boolean registrarEvento(LogDTO log);
}
