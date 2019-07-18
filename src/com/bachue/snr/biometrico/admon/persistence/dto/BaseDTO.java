package com.bachue.snr.biometrico.admon.persistence.dto;


import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
/**
 *
 * @version 1.0
 * @author Barras y Recaudos.
 * Nota: DTO de base que contiene las propiedades comunes de los DTOs.
 *
 */
public class BaseDTO {

  protected String is_ip;

  protected Timestamp it_time;

  public String getIp() {
    return is_ip;
  }

  public void setIp(String as_ip) {
    this.is_ip = as_ip;
  }

  public Timestamp getTime() {
    return it_time;
  }

  public void setTime(Timestamp at_time) {
    this.it_time = at_time;
  }

  /**
   * Metodo que agrega los campos de auditoria que son obtenibles desde el request.
   * @param ahsr_req Request con la informacion HTTP de la peticion recibida.
   */
  public void agregarValoresAuditoria(HttpServletRequest ahsr_req) {
    this.setIp(ahsr_req.getRemoteAddr());
    this.setTime(new Timestamp(new Date().getTime()));
  }
}
