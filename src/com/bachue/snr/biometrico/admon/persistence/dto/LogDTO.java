package com.bachue.snr.biometrico.admon.persistence.dto;

import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de logs.
 *
 */
public class LogDTO extends BaseDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String is_id;

  private String is_detalle;

  private String is_evento;

  private String is_userId;

  public String getId() {
    return is_id;
  }

  public void setId(String as_id) {
    this.is_id = as_id;
  }

  public String getDetalle() {
    return is_detalle;
  }

  public void setDetalle(String as_detalle) {
    this.is_detalle = as_detalle;
  }

  public String getEvento() {
    return is_evento;
  }

  public void setEvento(String as_evento) {
    this.is_evento = as_evento;
  }

  public String getUserId() {
    return is_userId;
  }

  public void setUserId(String as_userId) {
    this.is_userId = as_userId;
  }
}