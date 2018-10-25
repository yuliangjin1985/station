package com.mum.station.service;

import com.mum.station.domain.Station;

import java.util.List;

public interface StationService {
  public Station addStation(Station station);

  boolean removeStation(long id);

  boolean updateStation(Station station);

  Station getByName(String name);

  Station getByStationId(String stationId);


  List<Station> searchedHdEnabled(boolean enabled);
}
