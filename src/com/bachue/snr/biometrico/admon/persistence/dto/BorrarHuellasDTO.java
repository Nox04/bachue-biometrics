package com.bachue.snr.biometrico.admon.persistence.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de borrado de huellas.
 *
 */
public class BorrarHuellasDTO extends BaseDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  @Valid
  @NotNull
  private String is_idUsuario;

  @Valid
  @NotNull
  private String is_idUsuarioCreacion;

  @XmlElement(required = true)
  public String getIdUsuario() {
    return is_idUsuario;
  }

  public void setIdUsuario(String as_idUsuario) {
    this.is_idUsuario = as_idUsuario;
  }

  @XmlElement(required = true)
  public String getIdUsuarioCreacion() {
    return is_idUsuarioCreacion;
  }

  public void setIdUsuarioCreacion(String as_idUsuarioCreacion) {
    this.is_idUsuarioCreacion = as_idUsuarioCreacion;
  }
}
