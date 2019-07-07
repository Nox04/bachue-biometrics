package com.bachue.snr.biometrico.libraries.shared.dtos.helper;

import com.bachue.snr.biometrico.libraries.shared.dtos.LogDTO;
import com.bachue.snr.biometrico.libraries.shared.persistence.model.Log;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Helper de conversión entre DTO y DAO de log.
 *
 */
public class BiometriaLogHelper {

    private BiometriaLogHelper() {}

    public static LogDTO toDto(Log entidad) {

      LogDTO log = new LogDTO();

      log.setId(entidad.getIdLog());
      log.setEvento(entidad.getEvento());
      log.setDetalle(entidad.getDetalle());

      return log;
    }

    public static Log toEntity(LogDTO modelo) {

      Log log = new Log();

      log.setIdLog(modelo.getId());
      log.setEvento(modelo.getEvento());
      log.setDetalle(modelo.getDetalle());
      log.setIdUsuarioCreacion(modelo.getUserId());
      log.setIpCreacion(modelo.getIp());
      log.setFechaCreacion(modelo.getTime());

      return log;
    }
}
