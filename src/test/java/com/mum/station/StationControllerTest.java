package com.mum.station;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mum.station.controller.StationController;
import com.mum.station.domain.Station;
import com.mum.station.service.StationService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

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

  @Test
  public void testRemoveStation() throws Exception {
    when(stationService.removeStation(25l)).thenReturn(1);
    mockMvc.perform(delete("/station/25"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(containsString("Remove successfully")));
  }

  @Test
  public void testUpdateStation() throws Exception {
    Station station = new Station(2l, "station Name", "station 01003", true, "call sign");
    String requestStr = new ObjectMapper().writer().withDefaultPrettyPrinter().writeValueAsString(station);
    when(stationService.updateStation(any())).thenReturn(true);
    mockMvc.perform(put("/station")
        .contentType(MediaType.APPLICATION_JSON)
        .content(requestStr))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(MockMvcResultMatchers.content().string(containsString("Update successfully")));
  }

  @Test
  public void testSearchByName() throws Exception {
    Station station = new Station(2l, "station Name", "station 01003", true, "call sign");
    when(stationService.getByName(any())).thenReturn(station);
    mockMvc.perform(get("/station/name")
        .param("name", "station name"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("station Name"))
        .andExpect(jsonPath("stationId").value("station 01003"))
        .andExpect(jsonPath("callSign").value("call sign"))
    ;
  }

  @Test
  public void testSearchByStationId() throws Exception {
    Station station = new Station(2l, "station Name", "station 01003", true, "call sign");
    when(stationService.getByStationId(any())).thenReturn(station);
    mockMvc.perform(get("/station/id")
        .param("stationId", "station 01003"))
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(jsonPath("name").value("station Name"))
        .andExpect(jsonPath("stationId").value("station 01003"))
        .andExpect(jsonPath("callSign").value("call sign"))
    ;
  }

  @Test
  public void testSearchHdEnabled() throws Exception {
    Station station = new Station(2l, "station Name", "station 01003", true, "call sign");
    Station station1 = new Station(3l, "station Name", "station 01003", true, "call sign");
    List<Station> list = new ArrayList<>();
    list.add(station);
    list.add(station1);
    when(stationService.searchedHdEnabled(true)).thenReturn(list);
    mockMvc.perform(get("/station/hds"))
        .andDo(print())
        .andExpect(status().isOk())
    ;
  }
}
