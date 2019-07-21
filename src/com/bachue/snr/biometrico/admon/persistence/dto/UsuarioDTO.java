package com.bachue.snr.biometrico.admon.persistence.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de usuarios.
 *
 */
public class UsuarioDTO extends BaseDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private String is_idUsuario;
  private String is_clave;
  private Timestamp it_fechaVencimiento;
  private char ic_claveActiva;

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

  public Timestamp getFechaVencimiento() {
    return it_fechaVencimiento;
  }

  public void setFechaVencimiento(Timestamp at_fechaVencimiento) {
    this.it_fechaVencimiento = at_fechaVencimiento;
  }

  public char getClaveActiva() {
    return ic_claveActiva;
  }

  public void setClaveActiva(char ac_claveActiva) {
    this.ic_claveActiva = ac_claveActiva;
  }
}
