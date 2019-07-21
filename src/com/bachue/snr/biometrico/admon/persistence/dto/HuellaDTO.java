package com.bachue.snr.biometrico.admon.persistence.dto;

import com.bachue.snr.biometrico.admon.enums.DedosEnum;

import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de huellas.
 *
 */
public class HuellaDTO extends BaseDTO implements Serializable{

  private static final long serialVersionUID = 1L;

  private Integer ii_id;
  private DedosEnum ide_posicion;
  private String is_template;

  public Integer getId() {
    return ii_id;
  }

  public void setId(Integer ai_id) {
    this.ii_id = ai_id;
  }

  public DedosEnum getPosicion() {
    return ide_posicion;
  }

  public void setPosicion(DedosEnum ade_posicion) {
    this.ide_posicion = ade_posicion;
  }

  public String getTemplate() {
    return is_template;
  }

  public void setTemplate(String as_template) {
    this.is_template = as_template;
  }
}