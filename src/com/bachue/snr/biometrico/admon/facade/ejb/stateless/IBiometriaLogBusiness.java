package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Interface de lógica de negocio de logs.
 *
 */
public interface IBiometriaLogBusiness {
  public Boolean registrarEvento(LogDTO log);
}
