package com.bachue.snr.biometrico.admon.persistence.dto;

import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: DTO de logs.
 *
 */
public class LogDTO extends BaseDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String id;

  private String evento;

  private String detalle;

  private String userId;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public String getEvento() {
    return evento;
  }

  public void setEvento(String evento) {
    this.evento = evento;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }
}