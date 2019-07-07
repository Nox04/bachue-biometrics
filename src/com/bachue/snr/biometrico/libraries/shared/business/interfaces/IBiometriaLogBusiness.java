package com.bachue.snr.biometrico.libraries.shared.business.interfaces;

import com.bachue.snr.biometrico.libraries.shared.dtos.LogDTO;

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
