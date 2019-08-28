package com.bachue.snr.biometrico.admon.persistence.helper;

import com.bachue.snr.biometrico.admon.enums.ValidacionesEnum;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Enum que relaciona dedos y su posicion en la mano.
 *
 */
public class ValidadorHelper {

  public static String validarClave(String as_clave, String as_patron, String as_minimo, String as_maximo) {

    if (as_clave.length() < Integer.parseInt(as_minimo)) {
      return ValidacionesEnum.CLAVE_CORTA.consultarMensaje();
    } else if (as_clave.length() > Integer.parseInt(as_maximo)) {
      return ValidacionesEnum.CLAVE_LARGA.consultarMensaje();
    } else if(!as_clave.matches(as_patron)) {
      return ValidacionesEnum.POCA_COMPLEJIDAD.consultarMensaje();
    }

    return ValidacionesEnum.VALIDACION_EXITOSA.consultarMensaje();
  }
}
