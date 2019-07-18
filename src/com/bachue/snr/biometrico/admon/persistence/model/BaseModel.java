package com.bachue.snr.biometrico.admon.persistence.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: Modelo de base con los campos de auditoria.
 *
 */
@MappedSuperclass
public class BaseModel {

  @Column(name = "FECHA_CREACION", length = 6, nullable = false)
  protected Timestamp fechaCreacion;

  @Column(name = "FECHA_MODIFICACION", length = 6)
  protected Timestamp fechaModificacion;

  @Column(name = "IP_CREACION", length = 100, nullable = false)
  protected String ipCreacion;

  @Column(name = "IP_MODIFICACION", length = 100)
  protected String ipModificacion;

  @Column(name = "ID_USUARIO_CREACION", length = 30, nullable = false)
  protected String idUsuarioCreacion;

  @Column(name = "ID_USUARIO_MODIFICACION", length = 30)
  protected String idUsuarioModificacion;

  public Timestamp getFechaCreacion() {
    return fechaCreacion;
  }

  public void setFechaCreacion(Timestamp fechaCreacion) {
    this.fechaCreacion = fechaCreacion;
  }

  public Timestamp getFechaModificacion() {
    return fechaModificacion;
  }

  public void setFechaModificacion(Timestamp fechaModificacion) {
    this.fechaModificacion = fechaModificacion;
  }

  public String getIpCreacion() {
    return ipCreacion;
  }

  public void setIpCreacion(String ipCreacion) {
    this.ipCreacion = ipCreacion;
  }

  public String getIpModificacion() {
    return ipModificacion;
  }

  public void setIpModificacion(String ipModificacion) {
    this.ipModificacion = ipModificacion;
  }

  public String getIdUsuarioCreacion() {
    return idUsuarioCreacion;
  }

  public void setIdUsuarioCreacion(String idUsuarioCreacion) {
    this.idUsuarioCreacion = idUsuarioCreacion;
  }

  public String getIdUsuarioModificacion() {
    return idUsuarioModificacion;
  }

  public void setIdUsuarioModificacion(String idUsuarioModificacion) {
    this.idUsuarioModificacion = idUsuarioModificacion;
  }
}
