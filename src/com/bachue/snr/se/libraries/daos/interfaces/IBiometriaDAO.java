package com.bachue.snr.se.libraries.daos.interfaces;

import javax.ejb.Local;

@Local
public interface IBiometriaDAO {
  public Boolean consultarHuella(Integer idUsuario);
}
