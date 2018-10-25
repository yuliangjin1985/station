package com.mum.station.controller;

import com.mum.station.domain.Station;
import com.mum.station.mapper.StationMapper;
import com.mum.station.service.StationService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StationController {

  @Autowired
  private StationMapper mapper;

  @Autowired
  private StationService stationService;

  @GetMapping("/")
  public String greeting() {
    Station station = new Station(0l, "name", "xxx", true, "");
    mapper.insert(station);
    log.info("start insert: " + station.toString());
    return "Hello World";
  }

  @PostMapping("/station")
  public Station addStation(@RequestParam(required = true) String name, @RequestParam(required = true) String stationId,
      @RequestParam boolean hdEnabled, @RequestParam(required = true) String callSign){
    Station station = new Station(name, stationId, hdEnabled, callSign);
    return stationService.addStation(station);
  }


}
