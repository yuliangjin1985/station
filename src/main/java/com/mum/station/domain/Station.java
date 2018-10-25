package com.mum.station.domain;

import lombok.Data;

@Data
public class Station {
  private Long id;
  private String stationId;
  private String name;
  private boolean hdEnabled;
  private String callSign;
}
