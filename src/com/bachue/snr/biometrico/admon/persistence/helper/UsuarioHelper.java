package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Usuario;
import com.bachue.snr.biometrico.biometrics.Criptografia;

import java.sql.Timestamp;
import java.time.LocalDate;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Helper de conversion entre DTO y DAO de usuario.
 *
 */
public class UsuarioHelper {

    private UsuarioHelper() {}

  /**
   * Metodo que mapea una entidad a su DTO correspondiente.
   * @param au_entidad que sera convertida a DTO.
   * @return DTO mapeado desde la entidad.
   */
    public static UsuarioDTO toDto(Usuario au_entidad) {

      UsuarioDTO lud_usuario = new UsuarioDTO();

      lud_usuario.setIdUsuario(au_entidad.getIdUsuario());
      lud_usuario.setClave(au_entidad.getClaveHash());
      lud_usuario.setFechaVencimiento(au_entidad.getFechaVencimiento());
      lud_usuario.setClaveActiva(au_entidad.getClaveActiva());

      return lud_usuario;
    }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param aud_usuarioDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
    public static Usuario toEntity(UsuarioDTO aud_usuarioDTO) {

      Usuario lu_usuario = new Usuario();

      lu_usuario.setIdUsuario(Criptografia.encrypt(aud_usuarioDTO.getIdUsuario()));
      lu_usuario.setClaveHash(Criptografia.encrypt(aud_usuarioDTO.getClave()));
      lu_usuario.setFechaVencimiento(Timestamp.valueOf(LocalDate.now().plusDays(45).atStartOfDay()));
      lu_usuario.setClaveActiva(aud_usuarioDTO.getClaveActiva());
      lu_usuario.setIdUsuarioCreacion(aud_usuarioDTO.getIdUsuarioCreacion());
      lu_usuario.setIpCreacion(aud_usuarioDTO.getIp());
      lu_usuario.setFechaCreacion(aud_usuarioDTO.getTime());

      return lu_usuario;
    }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param aud_usuarioDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
  public static Usuario usuarioConClave(UsuarioDTO aud_usuarioDTO) {

    Usuario lu_usuario = new Usuario();

    lu_usuario.setIdUsuario(Criptografia.encrypt(aud_usuarioDTO.getIdUsuario()));
    lu_usuario.setClaveHash(Criptografia.encrypt(aud_usuarioDTO.getClave()));
    lu_usuario.setIdUsuarioModificacion(aud_usuarioDTO.getIdUsuarioCreacion());
    lu_usuario.setIpModificacion(aud_usuarioDTO.getIp());
    lu_usuario.setFechaModificacion(aud_usuarioDTO.getTime());

    return lu_usuario;
  }
}
