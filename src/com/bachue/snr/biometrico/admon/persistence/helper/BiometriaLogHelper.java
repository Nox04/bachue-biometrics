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
public class BiometriaLogHelper {

    private BiometriaLogHelper() {}

  /**
   * Método que recibe la petición HTTP de enrolamiento y la mapea al DTO.
   * @param entidad que será convertida a DTO.
   * @return DTO mapeado desde la entidad.
   */
    public static LogDTO toDto(Log entidad) {

      LogDTO log = new LogDTO();

      log.setId(entidad.getIdLog());
      log.setEvento(entidad.getEvento());
      log.setDetalle(entidad.getDetalle());

      return log;
    }

  /**
   * Método que recibe la petición HTTP de enrolamiento y la mapea al DTO.
   * @param logDTO que será convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
    public static Log toEntity(LogDTO logDTO) {

      Log log = new Log();

      log.setIdLog(logDTO.getId());
      log.setEvento(logDTO.getEvento());
      log.setDetalle(logDTO.getDetalle());
      log.setIdUsuarioCreacion(logDTO.getUserId());
      log.setIpCreacion(logDTO.getIp());
      log.setFechaCreacion(logDTO.getTime());

      return log;
    }
}
