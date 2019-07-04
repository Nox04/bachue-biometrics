package com.bachue.snr.se.libraries.shared.dtos;

import java.io.Serializable;

public class LogDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private String id;

  private String evento;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getEvento() {
    return evento;
  }

  public void setEvento(String evento) {
    this.evento = evento;
  }
}