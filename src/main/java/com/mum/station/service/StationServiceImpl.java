package com.mum.station.service;

import com.mum.station.domain.Station;
import com.mum.station.mapper.StationMapper;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StationServiceImpl implements StationService{

  @Autowired
  private StationMapper mapper;

  @Override
  public Station addStation(Station station) {
    int insertId = mapper.insert(station);
    log.info("Inserted station id: " + insertId);
    return station;
  }
}
