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
 * Nota: Modelo de persistencia de sesión.
 *
 */
@Entity
@Table(name = "SDB_BGN_SESION")
public class Sesion extends BiometriaBase implements Serializable {
  private static final long serialVersionUID = 1L;

  public Sesion() {}

  @Id()
  @Column(name = "SESION", length = 200, nullable = false)
  private String sesion;

  @Column(name = "RESULTADO", nullable = false)
  private Boolean resultado;

  public String getSesion() {
    return sesion;
  }

  public void setSesion(String sesion) {
    this.sesion = sesion;
  }

  public Boolean getResultado() {
    return resultado;
  }

  public void setResultado(Boolean resultado) {
    this.resultado = resultado;
  }
}
