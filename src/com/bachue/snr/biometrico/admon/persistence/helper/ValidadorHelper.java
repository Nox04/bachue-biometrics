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

  public static String validarClave(String as_clave) {

    String ls_patron = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}";

    if (as_clave.length() < 8) {
      return ValidacionesEnum.CLAVE_CORTA.consultarMensaje();
    } else if (as_clave.length() > 32) {
      return ValidacionesEnum.CLAVE_LARGA.consultarMensaje();
    } else if(!as_clave.matches(ls_patron)) {
      return ValidacionesEnum.POCA_COMPLEJIDAD.consultarMensaje();
    }

    return ValidacionesEnum.VALIDACION_EXITOSA.consultarMensaje();
  }
}
