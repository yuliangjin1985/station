package com.mum.station.service;

import com.mum.station.domain.Station;
import com.mum.station.mapper.StationMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService{

  @Autowired
  private StationMapper mapper;

  @Override
  public Station addStation(Station station) {
    int insertId = mapper.insert(station);
    return station;
  }

  @Override
  public boolean removeStation(long id) {
    return false;
  }

  @Override
  public boolean updateStation(Station station) {
    return false;
  }

  @Override
  public Station getByName(String name) {
    return null;
  }

  @Override
  public Station getByStationId(String stationId) {
    return null;
  }

  @Override
  public List<Station> searchedHdEnabled(boolean enabled) {
    return null;
  }
}
