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
public interface IUsuarioDAO {
  /**
   * Metodo que registra el usuario en la tabla de usuarios.
   * @param au_usuario Modelo que sera almacenado en la base de datos.
   * @return true si el usuario es registrado con exito.
   */
  Boolean crearUsuario(Usuario au_usuario);

  /**
   * Metodo que actualiza la clave de usuario en la tabla de usuarios.
   * @param au_usuario Modelo que sera almacenado en la base de datos.
   * @return true si el usuario es registrado con exito.
   */
  Boolean actualizarClave(Usuario au_usuario);

  /**
   * Metodo que consulta un usuario en la tabla de usuarios.
   * @param idUsuario id del usuario consultado.
   * @return el usuario consultado
   */
  Usuario consultarUsuario(String idUsuario);

  /**
   * Metodo que actualiza la clave de usuario en la tabla de usuarios.
   * @param idUsuario Modelo que sera almacenado en la base de datos.
   * @return true si el usuario es registrado con exito.
   */
  Boolean borrarUsuario(String idUsuario);
}
