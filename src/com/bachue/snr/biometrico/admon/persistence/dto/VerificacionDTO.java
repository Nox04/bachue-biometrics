package com.bachue.snr.biometrico.admon.persistence.dto;


import com.bachue.snr.biometrico.admon.enums.DedosEnum;
import com.bachue.snr.biometrico.biometrics.Criptografia;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de verificacion.
 *
 */
public class VerificacionDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String is_sesion;
  private Integer ii_id;
  private DedosEnum ide_posicion;
  private String is_template;
  private String is_idUsuario;


  @XmlElement(required = true)
  public String getSesion() {
    return is_sesion;
  }

  public void setSesion(String as_sesion) {
    this.is_sesion = as_sesion;
  }

  @XmlTransient
  public Integer getId() {
    return ii_id;
  }

  public void setId(Integer ai_id) {
    this.ii_id = ai_id;
  }

  @XmlElement
  public DedosEnum getPosicion() {
    return ide_posicion;
  }

  public void setPosicion(DedosEnum ade_posicion) {
    this.ide_posicion = ade_posicion;
  }

  @XmlElement(required = true, name = "imagenHuella")
  public String getTemplate() {
    return is_template;
  }

  public void setTemplate(String as_template) {
    this.is_template = as_template;
  }

  @XmlElement(required = true)
  public String getIdUsuario() {
    return is_idUsuario;
  }

  public void setIdUsuario(String as_usuarioId) {
    this.is_idUsuario = Criptografia.encrypt(as_usuarioId);
  }

}