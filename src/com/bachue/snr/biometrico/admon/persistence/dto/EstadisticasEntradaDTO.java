package com.bachue.snr.biometrico.admon.persistence.dto;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de entrada de estadisticas.
 *
 */
public class EstadisticasEntradaDTO {

  private String is_idEntidad;
  private String is_tipo;

  public String getIdEntidad() {
    return is_idEntidad;
  }

  public void setIdEntidad(String as_idEntidad) {
    this.is_idEntidad = as_idEntidad;
  }

  public String getTipo() {
    return is_tipo;
  }

  public void setTipo(String as_tipo) {
    this.is_tipo = as_tipo;
  }
}
