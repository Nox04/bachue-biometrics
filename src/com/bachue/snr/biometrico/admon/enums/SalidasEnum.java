package com.bachue.snr.biometrico.admon.enums;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Enum que relaciona las salidas y sus codigos.
 *
 */
public enum SalidasEnum {
  RECURSO_EXITOSO("200", "OK"),
  RECURSO_NO_AUTORIZADO("401", "Recurso no autorizado"),
  RECURSO_NO_ENCONTRADO("404", "Recurso no encontrado"),
  EXCEPCION_NO_CONTROLADA("500", "Excepción no controlada");

  private final String cs_codigo;
  private final String cs_mensaje;

  SalidasEnum(final String as_codigo, String as_mensaje) {
    this.cs_codigo = as_codigo;
    this.cs_mensaje = as_mensaje;
  }

  /**
   * Metodo que retorna el codigo de la respuesta.
   * @return el nombre del dedo.
   */
  public String consultarCodigo() {
    return cs_codigo;
  }

  /**
   * Metodo que retorna el mensaje.
   * @return la posicion del dedo.
   */
  public String consultarMensaje() {
    return cs_mensaje;
  }

}