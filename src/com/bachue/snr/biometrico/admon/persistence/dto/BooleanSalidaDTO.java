package com.bachue.snr.biometrico.admon.persistence.dto;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de salida para booleanos.
 *
 */
public class BooleanSalidaDTO extends BaseSalidaDTO {

  private Boolean ib_resultado;

  public Boolean getResultado() {
    return ib_resultado;
  }

  public void setResultado(Boolean ab_resultado) {
    this.ib_resultado = ab_resultado;
  }
}
