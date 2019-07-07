package com.bachue.snr.biometrico.admon.persistence.dto;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @version 1.0
 * @author Barras y Recaudos
 * Nota: DTO de base que contiene las propiedades comunes de los DTOs.
 *
 */
public class BaseDTO {

  protected String ip;

  protected Timestamp time;

  public String getIp() {
    return ip;
  }

  public void setIp(String ip) {
    this.ip = ip;
  }

  public Timestamp getTime() {
    return time;
  }

  public void setTime(Timestamp time) {
    this.time = time;
  }

  public void agregarValoresAuditoria(HttpServletRequest req) {
    this.setIp(req.getRemoteAddr());
    this.setTime(new Timestamp(new Date().getTime()));
  }
}
