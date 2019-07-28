package com.bachue.snr.biometrico.admon.enums;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Enum que relaciona los mensajes de valicacion
 *
 */
public enum ValidacionesEnum {
  VALIDACION_EXITOSA("Validado exitosamente"),
  CLAVE_LARGA("La contraseña es demasiado larga"),
  CLAVE_CORTA("La contraseña es demasiado corta"),
  POCA_COMPLEJIDAD("La contraseña debe tener al menos un caracter en minúscula, uno en mayúscula y un símbolo especial");

  private final String cs_mensaje;

  ValidacionesEnum(final String as_mensaje) {
    this.cs_mensaje = as_mensaje;
  }

  /**
   * Metodo que retorna el mensaje de validacion
   */
  public String consultarMensaje() {
    return cs_mensaje;
  }
}
