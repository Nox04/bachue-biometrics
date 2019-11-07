package com.bachue.snr.biometrico.admon.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de persistencia de usuario.
 *
 */
@Entity
@Table(name = "SDB_AUT_USUARIO", schema = "ADM_SDB")
public class UsuarioBachue implements Serializable {
  private static final long serialVersionUID = 1L;

  public UsuarioBachue() {}

  @Id()
  @Column(name = "ID_USUARIO", length = 30, nullable = false)
  private String idUsuario;

  @Column(name = "SEGUNDO_FACTOR_AUTENTICACION", length = 30)
  private String segundoFactorAutenticacion;

  public String getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(String idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getSegundoFactorAutenticacion() {
    return segundoFactorAutenticacion;
  }

  public void setSegundoFactorAutenticacion(String segundoFactorAutenticacion) {
    this.segundoFactorAutenticacion = segundoFactorAutenticacion;
  }
}
