package com.bachue.snr.se.libraries.shared.dtos;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
