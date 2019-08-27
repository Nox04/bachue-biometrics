package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import javax.ejb.Local;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de DAO de logs.
 *
 */
@Local
public interface IUsuarioBachueDAO {
  /**
   * Metodo que obtiene el segundo factor del usuario en la tabla de usuarios.
   * @param as_usuarioId Modelo que sera almacenado en la base de datos.
   * @return segundo factor de autenticacion.
   */
  String obtenerSegundoFactor(String as_usuarioId);
}
