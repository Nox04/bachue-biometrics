package com.bachue.snr.biometrico.libraries.daos.interfaces;

import com.bachue.snr.biometrico.libraries.shared.persistence.model.Log;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Interface de DAO de logs.
 *
 */
@Local
public interface IBiometriaLogDAO {
  public Boolean registrarEvento(Log log);
}
