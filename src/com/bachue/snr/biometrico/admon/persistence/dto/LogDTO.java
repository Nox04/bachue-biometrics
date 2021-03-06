package com.bachue.snr.biometrico.admon.persistence.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de logs.
 *
 */
public class LogDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String is_id;

  private String is_detalle;

  private String is_evento;

  private String is_idEntidad;

  private String is_idUsuario;

  @XmlTransient
  public String getId() {
    return is_id;
  }

  public void setId(String as_id) {
    this.is_id = as_id;
  }

  @XmlElement(required = true)
  public String getDetalle() {
    return is_detalle;
  }

  public void setDetalle(String as_detalle) {
    this.is_detalle = as_detalle;
  }

  @XmlElement(required = true)
  public String getEvento() {
    return is_evento;
  }

  public void setEvento(String as_evento) {
    this.is_evento = as_evento;
  }

  @XmlElement(required = true)
  public String getIdEntidad() {
    return is_idEntidad;
  }

  public void setIdEntidad(String as_idEntidad) {
    this.is_idEntidad = as_idEntidad;
  }

  @XmlElement(required = true)
  public String getIdUsuario() {
    return is_idUsuario;
  }

  public void setIdUsuario(String as_idUsuario) {
    is_idUsuario = as_idUsuario;
  }
}