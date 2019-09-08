package com.bachue.snr.biometrico.admon.persistence.dto;


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
public class VerificacionDTO extends HuellaDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String is_sesion;


  @XmlElement(required = true)
  public String getSesion() {
    return is_sesion;
  }

  public void setSesion(String as_sesion) {
    this.is_sesion = as_sesion;
  }

  @Override
  @XmlTransient
  public String getIdUsuarioCreacion() {
    return is_idUsuarioCreacion;
  }

  @Override
  @XmlTransient
  public void setIdUsuarioCreacion(String as_usuarioCreacionId) {
    this.is_idUsuarioCreacion = as_usuarioCreacionId;
  }

}