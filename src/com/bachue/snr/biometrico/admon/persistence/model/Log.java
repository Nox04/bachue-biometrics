package com.bachue.snr.biometrico.admon.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de persistencia de log.
 *
 */
@Entity
@Table(name = "SDB_BGN_LOG")
public class Log extends BaseModel implements Serializable {
  private static final long serialVersionUID = 1L;

  public Log() {}

  @Id()
  @Column(name = "ID_LOG", length = 20)
  @GeneratedValue
  private String idLog;

  @Column(name = "EVENTO", nullable = false, length = 50)
  private String evento;

  @Column(name = "ID_ENTIDAD", nullable = false)
  private String idEntidad;

  @Column(name = "DETALLE", nullable = false)
  private String detalle;

  public String getDetalle() {
    return detalle;
  }

  public void setDetalle(String detalle) {
    this.detalle = detalle;
  }

  public String getIdLog() {
    return idLog;
  }

  public void setIdLog(String idLog) {
    this.idLog = idLog;
  }

  public String getEvento() {
    return evento;
  }

  public void setEvento(String evento) {
    this.evento = evento;
  }

  public String getIdEntidad() {
    return idEntidad;
  }

  public void setIdEntidad(String idEntidad) {
    this.idEntidad = idEntidad;
  }
}
