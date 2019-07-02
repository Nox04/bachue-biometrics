package com.bachue.snr.se.libraries.shared.persistence.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "HELP")
public class Huella implements Serializable {
  private static final long serialVersionUID = 1L;

  @Column(name = "TOPIC")
  private String topic;

  @Column(name = "INFO")
  private String info;

  @Column(name = "SEQ")
  private Integer seq;


  public Huella() {}

  public String getTopic() {
    return topic;
  }

  public void setTopic(String topic) {
    this.topic = topic;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Integer getSeq() {
    return seq;
  }

  public void setSeq(Integer seq) {
    this.seq = seq;
  }
}
