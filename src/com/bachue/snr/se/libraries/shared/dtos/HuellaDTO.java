package com.bachue.snr.se.libraries.shared.dtos;

import com.bachue.snr.se.libraries.enums.DedosEnum;

import java.io.Serializable;

public class HuellaDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer id;
  private DedosEnum huella;
  private Integer posicion;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DedosEnum getHuella() {
    return huella;
  }

  public void setHuella(DedosEnum huella) {
    this.huella = huella;
  }

  public Integer getPosicion() {
    return posicion;
  }

  public void setPosicion(Integer posicion) {
    this.posicion = posicion;
  }
}