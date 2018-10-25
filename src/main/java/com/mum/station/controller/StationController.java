package com.mum.station.controller;

import com.mum.station.domain.Station;
import com.mum.station.mapper.StationMapper;
import com.mum.station.service.StationService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class StationController {

  @Autowired
  private StationService stationService;

  @PostMapping("/station")
  public Station addStation(@RequestBody Station station){
    return stationService.addStation(station);
  }

  @DeleteMapping("/station/{id}")
  public String removeStation(@PathVariable long id) {
    stationService.removeStation(id);
    return "Remove successfully";
  }

  @PutMapping("/station")
  public String updateStation(@RequestBody Station station) {
    stationService.updateStation(station);
    return "Update successfully";
  }

  @GetMapping("/station/name")
  public Station searchByName(@RequestParam String name) {
    return stationService.getByName(name);
  }


  @GetMapping("/station/id")
  public Station searchByStationId(@RequestParam String stationId) {
    return stationService.getByStationId(stationId);
  }

  @GetMapping("/station/hds")
  public List<Station> searchHdEnabled() {
    return stationService.searchedHdEnabled(true);
  }
}
