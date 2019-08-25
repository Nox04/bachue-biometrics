package com.bachue.snr.biometrico.admon.persistence.dto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de usuarios.
 *
 */
public class UsuarioDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  @Valid
  @NotNull
  private String is_idUsuario;

  @Valid
  @NotNull
  private String is_clave;

  private Date it_fechaVencimiento;
  private char ic_claveActiva;

  @Valid
  @NotNull
  private String is_idUsuarioCreacion;


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

  public Date getFechaVencimiento() {
    return it_fechaVencimiento;
  }

  public void setFechaVencimiento(Date at_fechaVencimiento) {
    this.it_fechaVencimiento = at_fechaVencimiento;
  }

  public char getClaveActiva() {
    return ic_claveActiva;
  }

  public void setClaveActiva(char ac_claveActiva) {
    this.ic_claveActiva = ac_claveActiva;
  }

  public String getIdUsuarioCreacion() {
    return is_idUsuarioCreacion;
  }

  public void setIdUsuarioCreacion(String as_idUsuarioCreacion) {
    this.is_idUsuarioCreacion = as_idUsuarioCreacion;
  }
}
