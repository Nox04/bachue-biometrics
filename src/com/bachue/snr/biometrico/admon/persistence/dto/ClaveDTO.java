package com.bachue.snr.biometrico.admon.persistence.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de usuarios.
 *
 */
public class ClaveDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String is_idUsuario;
  private String is_clave;
  private String is_idUsuarioCreacion;
  private String is_sesion;


  public String getIdUsuario() {
    return is_idUsuario;
  }

  public void setIdUsuario(String as_idUsuario) {
    this.is_idUsuario = as_idUsuario;
  }

  public String getClave() {
    return is_clave;
  }

  public void setClave(String as_clave) {
    this.is_clave = as_clave;
  }

  public String getIdUsuarioCreacion() {
    return is_idUsuarioCreacion;
  }

  public void setIdUsuarioCreacion(String as_idUsuarioCreacion) {
    this.is_idUsuarioCreacion = as_idUsuarioCreacion;
  }

  public String getSesion() {
    return is_sesion;
  }

  public void setSesion(String as_sesion) {
    this.is_sesion = as_sesion;
  }
}
