package com.mum.station;

import com.mum.station.domain.Station;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = StationApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = { "management.server.port=8082" })
public class StationIntegrationTest {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate restTemplate;

  private String createURLWithPort(String uri) {
    return "http://localhost:" + port + uri;
  }

  @Test
  public void testAddStation() {
    HttpEntity<Station> request = new HttpEntity<>(new Station("my Station", "station_100.1", true, "sign " +
        "call"));
    Station station = restTemplate.postForObject(createURLWithPort("/station"), request, Station.class);
    Assert.assertEquals("my Station", station.getName() );
  }

  //Test remove:
  // step 1, add a new Station
  // step 2, search the new Station to verify step 1 finish successfully
  // step 3, revoke remove function
  // step 4, search again to verify the Station was removed successfully

  @Test
  public void testRemoveStation() {
    HttpEntity<Station> request = new HttpEntity<>(new Station("my Station", "station_100.1", true, "sign " +
        "call"));
    restTemplate.postForObject(createURLWithPort("/station"), request, Station.class);
    Station station = restTemplate.getForObject(createURLWithPort("/station/id?stationId=station_100.1"), Station.class);
    Assert.assertNotNull(station);
    restTemplate.delete(createURLWithPort("/station/" + station.getId()));
    Station stationNew = restTemplate.getForObject(createURLWithPort("/station/id?stationId=station_100.1"), Station
        .class);
    Assert.assertNull(stationNew);
  }

  @Test
  public void testSearchByName() {
    HttpEntity<Station> request = new HttpEntity<>(new Station("my Station for integration test", "station_100.1",
        true, "sign call"));
    restTemplate.postForObject(createURLWithPort("/station"), request, Station.class);
    Station station = restTemplate.getForObject(createURLWithPort("/station/name?name=my Station for integration test"), Station.class);
    Assert.assertNotNull(station);
    Assert.assertEquals("my Station for integration test", station.getName());
    Assert.assertEquals("station_100.1", station.getStationId());
  }

  @Test
  public void testSearchHdEnabled(){
    HttpEntity<Station> request1 = new HttpEntity<>(new Station("my Station for integration test1", "station_100.11",
        true, "sign call"));
    HttpEntity<Station> request2 = new HttpEntity<>(new Station("my Station for integration test2", "station_100.12",
        false, "sign call"));
    restTemplate.postForObject(createURLWithPort("/station"), request1, Station.class);
    restTemplate.postForObject(createURLWithPort("/station"), request2, Station.class);

    List list = restTemplate.getForObject(createURLWithPort("/station/hds"), List.class);
    Assert.assertNotNull(list);
    Assert.assertEquals(1, list.size());
  }
}
