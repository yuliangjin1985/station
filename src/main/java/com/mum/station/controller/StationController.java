package com.mum.station.controller;

import com.mum.station.domain.Station;
import com.mum.station.mapper.StationMapper;
import com.mum.station.service.StationService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class StationController {

  @Autowired
  private StationService stationService;

  @GetMapping("/")
  public String greeting() {
    return "Hello World";
  }

  @PostMapping("/station")
  public Station addStation(@RequestBody Station station){
    return stationService.addStation(station);
  }


}
