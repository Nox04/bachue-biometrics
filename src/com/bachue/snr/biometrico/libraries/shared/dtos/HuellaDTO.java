package com.bachue.snr.biometrico.libraries.shared.dtos;

import com.bachue.snr.biometrico.libraries.enums.DedosEnum;

import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: DTO de huellas.
 *
 */
public class HuellaDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer id;
  private DedosEnum position;
  private String template;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public DedosEnum getPosition() {
    return position;
  }

  public void setPosition(DedosEnum position) {
    this.position = position;
  }

  public String getTemplate() {
    return template;
  }

  public void setTemplate(String template) {
    this.template = template;
  }
}