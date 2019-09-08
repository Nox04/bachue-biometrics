package com.bachue.snr.biometrico.admon.persistence.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de persistencia de usuario.
 *
 */
@Entity
@Table(name = "SDB_PGN_CONSTANTES")
public class Constante implements Serializable {
  private static final long serialVersionUID = 1L;

  public Constante() {}

  @Id()
  @Column(name = "ID_CONSTANTE", length = 30, nullable = false)
  private String idConstante;

  @Column(name = "CARACTER", length = 400)
  private String caracter;

  public String getIdConstante() {
    return idConstante;
  }

  public void setIdConstante(String idConstante) {
    this.idConstante = idConstante;
  }

  public String getCaracter() {
    return caracter;
  }

  public void setCaracter(String caracter) {
    this.caracter = caracter;
  }
}

