package com.bachue.snr.se.libraries.shared.dtos;

import java.io.Serializable;

public class LogDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String id;

  private String evento;

  private String detalle;

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
}