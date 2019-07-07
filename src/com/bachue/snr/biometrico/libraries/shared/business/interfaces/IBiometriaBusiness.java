package com.bachue.snr.biometrico.libraries.shared.business.interfaces;

import com.bachue.snr.biometrico.libraries.shared.dtos.HuellaDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Interface de lógica de operaciones biométricas.
 *
 */
public interface IBiometriaBusiness {

  public Boolean enrolarHuella(HuellaDTO huella);
  public Boolean verificarHuella(HuellaDTO huella);
}
