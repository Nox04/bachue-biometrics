package com.bachue.snr.biometrico.admon.persistence.dto;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de salida de estadisticas.
 *
 */
public class EstadisticasSalidaDTO extends BaseSalidaDTO {

  private int ii_contador;

  public int getContador() {
    return ii_contador;
  }

  public void setContador(int ai_contador) {
    this.ii_contador = ai_contador;
  }
}
