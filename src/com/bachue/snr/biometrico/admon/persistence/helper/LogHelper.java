package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.LogDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Log;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Helper de conversión entre DTO y DAO de log.
 *
 */
public class LogHelper {

    private LogHelper() {}

  /**
   * Método que mapea una entidad a su DTO correspondiente.
   * @param al_entidad que será convertida a DTO.
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
   * Método que mapea un DTO a su entidad correspondiente.
   * @param ald_logDTO que será convertido a la entidad correspondiente.
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
}
