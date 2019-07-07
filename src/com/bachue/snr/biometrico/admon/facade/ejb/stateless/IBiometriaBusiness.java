package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;

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
