package com.bachue.snr.se.libraries.shared.dtos.helper;

import com.bachue.snr.se.libraries.shared.dtos.LogDTO;
import com.bachue.snr.se.libraries.shared.persistence.model.Log;

public class BiometriaLogHelper {

    private BiometriaLogHelper() {}

    public static LogDTO toDto(Log entidad) {

      LogDTO log = new LogDTO();

      log.setId(entidad.getIdLog());
      log.setEvento(entidad.getEvento());

      return log;
    }

    public static Log toEntity(LogDTO modelo) {

      Log log = new Log();

      log.setIdLog(modelo.getId());
      log.setEvento(modelo.getEvento());

      return log;
    }
}
