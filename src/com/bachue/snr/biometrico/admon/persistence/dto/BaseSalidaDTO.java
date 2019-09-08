package com.bachue.snr.biometrico.admon.persistence.dto;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de base que contiene las propiedades comunes de los DTOs de salida.
 *
 */
public class BaseSalidaDTO {

  protected String is_codigo;

  protected String is_mensaje;

  public String getCodigo() {
    return is_codigo;
  }

  public void setCodigo(String as_codigo) {
    this.is_codigo = as_codigo;
  }

  public String getMensaje() {
    return is_mensaje;
  }

  public void setMensaje(String as_mensaje) {
    this.is_mensaje = as_mensaje;
  }
}
