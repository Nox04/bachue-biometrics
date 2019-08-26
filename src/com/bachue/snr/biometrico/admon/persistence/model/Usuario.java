package com.bachue.snr.biometrico.admon.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de persistencia de usuario.
 *
 */
@Entity
@Table(name = "SDB_AUT_USUARIO")
public class Usuario extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;

  public Usuario() {}

  @Id()
  @Column(name = "ID_USUARIO_HASH", length = 200, nullable = false)
  private String idUsuario;

  @Column(name = "CLAVE_HASH", length = 200, nullable = false)
  private String claveHash;

  @Column(name = "FECHA_VENCIMIENTO", length = 6)
  private Timestamp fechaVencimiento;

  @Column(name = "CLAVE_ACTIVA", length = 1)
  private char claveActiva;

  public String getIdUsuario() {
    return idUsuario;
  }

  public void setIdUsuario(String idUsuario) {
    this.idUsuario = idUsuario;
  }

  public String getClaveHash() {
    return claveHash;
  }

  public void setClaveHash(String claveHash) {
    this.claveHash = claveHash;
  }

  public Timestamp getFechaVencimiento() {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Timestamp fechaVencimiento) {
    this.fechaVencimiento = fechaVencimiento;
  }

  public char getClaveActiva() {
    return claveActiva;
  }

  public void setClaveActiva(char claveActiva) {
    this.claveActiva = claveActiva;
  }
}
