package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.persistence.dto.SesionDTO;
import com.bachue.snr.biometrico.admon.persistence.model.Sesion;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Helper de conversión entre DTO y DAO de sesión.
 *
 */
public class SesionHelper {

    private SesionHelper() {}

  /**
   * Método que mapea una entidad a su DTO correspondiente.
   * @param as_entidad que será convertida a DTO.
   * @return DTO mapeado desde la entidad.
   */
    public static SesionDTO toDto(Sesion as_entidad) {

      SesionDTO lsd_sesion = new SesionDTO();

      lsd_sesion.setSesion(as_entidad.getSesion());
      lsd_sesion.setResultado(as_entidad.getResultado());

      return lsd_sesion;
    }

  /**
   * Método que recibe la petición HTTP de enrolamiento y la mapea al DTO.
   * @param asd_sesionDTO que será convertido a la entidad correspondiente.
   * @return entidad mapeada desde el DTO recibido.
   */
    public static Sesion toEntity(SesionDTO asd_sesionDTO) {

      Sesion ls_sesion = new Sesion();

      ls_sesion.setSesion(asd_sesionDTO.getSesion());
      ls_sesion.setResultado(asd_sesionDTO.getResultado());

      return ls_sesion;
    }
}
