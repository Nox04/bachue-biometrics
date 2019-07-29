package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.HuellaDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.UsuarioDTO;
import com.bachue.snr.biometrico.admon.persistence.dto.VerificacionDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Log;
import com.bachue.snr.biometrico.biometrics.Criptografia;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Helper de conversion entre DTO y DAO de log.
 *
 */
public class LogHelper {

    private LogHelper() {}

  /**
   * Metodo que mapea una entidad a su DTO correspondiente.
   * @param al_entidad que sera convertida a DTO.
   * @return DTO mapeado desde la entidad.
   */
    public static LogDTO toDto(Log al_entidad) {

      LogDTO lld_log = new LogDTO();

      lld_log.setId(al_entidad.getIdLog());
      lld_log.setEvento(al_entidad.getEvento());
      lld_log.setDetalle(al_entidad.getDetalle());
      lld_log.setIdEntidad(al_entidad.getIdEntidad());

      return lld_log;
    }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param ald_logDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
    public static Log toEntity(LogDTO ald_logDTO) {

      Log ll_log = new Log();

      ll_log.setIdLog(ald_logDTO.getId());
      ll_log.setEvento(ald_logDTO.getEvento());
      ll_log.setDetalle(ald_logDTO.getDetalle());
      ll_log.setIdEntidad(ald_logDTO.getIdEntidad());
      ll_log.setIdUsuarioCreacion(ald_logDTO.getIdUsuario());
      ll_log.setIpCreacion(ald_logDTO.getIp());
      ll_log.setFechaCreacion(ald_logDTO.getTime());

      return ll_log;
    }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param avd_verificacionDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
  public static Log crearLogDeVerificacion(VerificacionDTO avd_verificacionDTO, boolean ab_resultado) {

    Log ll_log = new Log();

    ll_log.setEvento("VERIFICACION");
    String ls_detalle = ab_resultado ? "Usuario verificado exitosamente" : "El usuario no se pudo verificar";
    ll_log.setDetalle(ls_detalle);
    ll_log.setIdEntidad(Criptografia.decrypt(avd_verificacionDTO.getUsuarioId()));
    ll_log.setIdUsuarioCreacion(avd_verificacionDTO.getUsuarioCreacionId());
    ll_log.setIpCreacion(avd_verificacionDTO.getIp());
    ll_log.setFechaCreacion(avd_verificacionDTO.getTime());

    return ll_log;
  }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param ahd_huellaDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
  public static Log crearLogDeEnrolamiento(HuellaDTO ahd_huellaDTO, boolean ab_resultado) {

    Log ll_log = new Log();

    ll_log.setEvento("ENROLAMIENTO");
    String ls_detalle = ab_resultado ? "Usuario enrolado exitosamente" : "El usuario no se pudo enrolar";
    ll_log.setDetalle(ls_detalle);
    ll_log.setIdEntidad(Criptografia.decrypt(ahd_huellaDTO.getUsuarioId()));
    ll_log.setIdUsuarioCreacion(ahd_huellaDTO.getUsuarioCreacionId());
    ll_log.setIpCreacion(ahd_huellaDTO.getIp());
    ll_log.setFechaCreacion(ahd_huellaDTO.getTime());

    return ll_log;
  }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param aud_usuarioDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
  public static Log crearLogDeActualizacionDeClave(UsuarioDTO aud_usuarioDTO) {

    Log ll_log = new Log();

    ll_log.setEvento("CLAVE");
    ll_log.setDetalle("Cambio de clave exitoso");
    ll_log.setIdEntidad(aud_usuarioDTO.getIdUsuario());
    ll_log.setIdUsuarioCreacion(aud_usuarioDTO.getIdUsuarioCreacion());
    ll_log.setIpCreacion(aud_usuarioDTO.getIp());
    ll_log.setFechaCreacion(aud_usuarioDTO.getTime());

    return ll_log;
  }

  /**
   * Metodo que mapea un DTO a su entidad correspondiente.
   * @param aud_usuarioDTO que sera convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
  public static Log crearLogDeBorrado(UsuarioDTO aud_usuarioDTO) {

    Log ll_log = new Log();

    ll_log.setEvento("HUELLA");
    ll_log.setDetalle("Huellas borradas exitosamente");
    ll_log.setIdEntidad(aud_usuarioDTO.getIdUsuario());
    ll_log.setIdUsuarioCreacion(aud_usuarioDTO.getIdUsuarioCreacion());
    ll_log.setIpCreacion(aud_usuarioDTO.getIp());
    ll_log.setFechaCreacion(aud_usuarioDTO.getTime());

    return ll_log;
  }
}
