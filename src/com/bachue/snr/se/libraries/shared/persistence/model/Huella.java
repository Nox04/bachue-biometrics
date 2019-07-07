package com.bachue.snr.se.libraries.shared.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "SDB_BGN_HUELLA")
public class Huella extends BiometriaBase implements Serializable {
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
  @JoinColumn(name="ID_USUARIO", foreignKey = @ForeignKey(name = "FK_HUELLA_USUARIO"))
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
