package com.mum.station.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StationController {

  @GetMapping("/")
  public String greeting() {
    return "Hello World";
  }
}
