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
@Table(name = "SDB_AUT_HUELLA")
public class Huella extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;

  public Huella() {}

  @Id()
  @Column(name = "ID_HUELLA", length = 20)
  @GeneratedValue
  private String idHuella;

  @Column(name = "TEMPLATE", nullable = false)
  private byte[] template;

  @Column(name = "POSICION", length = 2, nullable = false)
  private int posicion;

  @ManyToOne(optional = false)
  @JoinColumn(name="ID_USUARIO_HASH")
  private Usuario usuario;

  public String getIdHuella() {
    return idHuella;
  }

  public void setIdHuella(String idHuella) {
    this.idHuella = idHuella;
  }

  public byte[] getTemplate() {
    return template;
  }

  public void setTemplate(byte[] template) {
    this.template = template;
  }

  public int getPosicion() {
    return posicion;
  }

  public void setPosicion(int posicion) {
    this.posicion = posicion;
  }

  public Usuario getUsuario() {
    return usuario;
  }

  public void setUsuario(Usuario usuario) {
    this.usuario = usuario;
  }
}
