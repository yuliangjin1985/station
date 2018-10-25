package com.mum.station.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Data
public class
Station {
  private long id;
  private String stationId;
  private String name;
  private boolean hdEnabled;
  private String callSign;

  public Station(String name, String stationId, boolean hdEnabled, String callSign) {
    this.name = name;
    this.stationId = stationId;
    this.hdEnabled = hdEnabled;
    this.callSign = callSign;
  }
}
