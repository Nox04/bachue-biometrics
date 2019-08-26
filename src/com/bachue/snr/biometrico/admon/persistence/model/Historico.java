package com.bachue.snr.biometrico.admon.persistence.model;


import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de persistencia de huella.
 *
 */
@Entity
@Table(name = "SDB_AUT_HISTORICO")
public class Historico extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;

  public Historico() {}

  @Id()
  @Column(name = "ID_USUARIO_HASH", length = 200, nullable = false)
  private String idUsuario;

  @Column(name = "CLAVE_HASH", length = 200, nullable = false)
  private String claveHash;

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
}
