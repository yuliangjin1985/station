package com.mum.station.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Data
public class Station implements Serializable {
  private long id;
  private String stationId;
  private String name;
  private boolean hdEnabled;
  private String callSign;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getStationId() {
    return stationId;
  }

  public void setStationId(String stationId) {
    this.stationId = stationId;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public boolean isHdEnabled() {
    return hdEnabled;
  }

  public void setHdEnabled(boolean hdEnabled) {
    this.hdEnabled = hdEnabled;
  }

  public String getCallSign() {
    return callSign;
  }

  public void setCallSign(String callSign) {
    this.callSign = callSign;
  }

  public Station(long id, String name, String stationId, boolean hdEnabled, String callSign) {
    this.id = id;
    this.name = name;
    this.stationId = stationId;
    this.hdEnabled = hdEnabled;
    this.callSign = callSign;
  }

  public Station(String name, String stationId, boolean hdEnabled, String callSign) {
    this.name = name;
    this.stationId = stationId;
    this.hdEnabled = hdEnabled;
    this.callSign = callSign;
  }

  public Station() {
  }




}
