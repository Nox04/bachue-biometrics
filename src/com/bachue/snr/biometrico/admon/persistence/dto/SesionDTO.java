package com.bachue.snr.biometrico.admon.persistence.dto;

import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de huellas.
 *
 */
public class SesionDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String is_sesion;
  private Boolean ib_resultado;

  public String getSesion() {
    return is_sesion;
  }

  public void setSesion(String as_sesion) {
    this.is_sesion = as_sesion;
  }


  public Boolean getResultado() {
    return ib_resultado;
  }

  public void setResultado(Boolean ab_resultado) {
    this.ib_resultado = ab_resultado;
  }
}