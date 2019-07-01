package com.bachue.snr.se.libraries.shared.business.interfaces;

import com.bachue.snr.se.libraries.shared.dtos.HuellaDTO;

public interface IBiometriaBusiness {

  public Boolean enrolarHuella(HuellaDTO huella);
  public Boolean verificarHuella(HuellaDTO huella);
}
