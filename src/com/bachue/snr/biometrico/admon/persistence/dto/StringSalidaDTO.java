package com.bachue.snr.biometrico.admon.persistence.dto;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de salida para strings.
 *
 */
public class StringSalidaDTO extends BaseSalidaDTO {

  private String is_resultado;

  public String getResultado() {
    return is_resultado;
  }

  public void setResultado(String as_resultado) {
    this.is_resultado = as_resultado;
  }
}
