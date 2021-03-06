package com.bachue.snr.biometrico.admon.facade.ejb.stateless;

import com.bachue.snr.biometrico.admon.persistence.dto.BooleanSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.ClaveDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.StringSalidaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Interface de logica de negocio de usuarios.
 *
 */
public interface IUsuarioBusiness {
  /**
   * Metodo que envia los datos del usuario al DAO para ser almacenado.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return true si el usuario es registrado con exito.
   */
  StringSalidaDTO crearUsuario(UsuarioDTO aud_usuario);

  /**
   * Metodo que cambia la clave del usuario.
   * @param aud_usuario DTO con la informacion del usuario.
   * @return true si el usuario es registrado con exito.
   */
  StringSalidaDTO actualizarClave(UsuarioDTO aud_usuario);

  /**
   * Metodo que verifica la existencia de un usuario.
   * @param as_id id del usuario.
   * @return true si el usuario existe.
   */
  StringSalidaDTO obtenerUsuario(String as_id);

  /**
   * Metodo que verifica la sesion de un usuario usando clave.
   * @param acd_clave id del usuario.
   * @return true si el usuario existe.
   */
  BooleanSalidaDTO verificarUsuario(ClaveDTO acd_clave);

  /**
   * Metodo que obtiene el tipo de segundo factor.
   * @param as_id id del usuario.
   * @return segundo factor de autenticacion.
   */
  StringSalidaDTO obtenerTipoSegundoFactor(String as_id);
}
