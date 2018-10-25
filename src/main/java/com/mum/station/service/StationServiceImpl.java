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
  public int removeStation(long id) {
    return mapper.deleteById(id);
  }

  @Override
  public boolean updateStation(Station station) {
    mapper.update(station);
    return true;
  }

  @Override
  public Station getByName(String name) {
    return mapper.searchByStationName(name);
  }

  @Override
  public Station getByStationId(String stationId) {
    return mapper.searchByStationId(stationId);
  }

  @Override
  public List<Station> searchedHdEnabled(boolean enabled) {
    return mapper.searchHdEnabled();
  }
}
