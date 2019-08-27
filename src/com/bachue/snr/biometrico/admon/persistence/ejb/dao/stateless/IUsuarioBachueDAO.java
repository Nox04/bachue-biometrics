package com.bachue.snr.biometrico.admon.persistence.ejb.dao.stateless;

import com.bachue.snr.biometrico.admon.persistence.model.Usuario;

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
   * Metodo que registra el usuario en la tabla de usuarios.
   * @param as_usuarioId Modelo que sera almacenado en la base de datos.
   * @return true si el usuario es registrado con exito.
   */
  String obtenerSegundoFactor(String as_usuarioId);
}
