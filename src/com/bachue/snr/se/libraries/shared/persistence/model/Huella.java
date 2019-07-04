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

  @Column(name = "TEMPLATE")
  private String template;

  @Column(name = "POSICION", length = 2)
  private int posicion;
}
