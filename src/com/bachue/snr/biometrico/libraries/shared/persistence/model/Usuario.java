package com.bachue.snr.biometrico.libraries.shared.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: Modelo de persistencia de usuario.
 *
 */
@Entity
@Table(name = "SDB_BGN_USUARIO")
public class Usuario extends BiometriaBase implements Serializable {
  private static final long serialVersionUID = 1L;

  public Usuario() {}

  @Id()
  @Column(name = "ID_USUARIO", length = 200, nullable = false)
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
