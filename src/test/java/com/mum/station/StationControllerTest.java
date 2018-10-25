package com.mum.station;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mum.station.controller.StationController;
import com.mum.station.domain.Station;
import com.mum.station.service.StationService;
import com.mum.station.service.StationServiceImpl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(StationController.class)
public class StationControllerTest {

  @MockBean
  private StationService stationService;

  @Autowired
  MockMvc mockMvc;

  @Test
  public void testPostStation() throws Exception {
    Station station = new Station(2l, "station Name", "station 01003", true, "call sign");
    String requestStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(station);
    when(stationService.addStation(any())).thenReturn(station);
    mockMvc.perform(post("/station")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestStr))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("station Name"))
        .andExpect(jsonPath("hdEnabled").value(true));
  }
}
