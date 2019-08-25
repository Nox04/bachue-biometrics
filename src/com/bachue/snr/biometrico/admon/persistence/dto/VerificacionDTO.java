package com.bachue.snr.biometrico.admon.persistence.dto;


import javax.xml.bind.annotation.XmlElement;
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

}