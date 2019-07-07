package com.bachue.snr.biometrico.libraries.daos.interfaces;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Interface de DAO de operaciones biométricas.
 *
 */
@Local
public interface IBiometriaDAO {
  public Boolean consultarHuella(Integer idUsuario);
}
