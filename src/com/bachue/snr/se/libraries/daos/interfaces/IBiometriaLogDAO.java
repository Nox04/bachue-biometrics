package com.bachue.snr.se.libraries.daos.interfaces;

import com.bachue.snr.se.libraries.shared.persistence.model.Log;

import javax.ejb.Local;

@Local
public interface IBiometriaLogDAO {
  public Boolean registrarEvento(Log log);
}
