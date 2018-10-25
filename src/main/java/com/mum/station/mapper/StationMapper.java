package com.mum.station.mapper;

import com.mum.station.domain.Station;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface StationMapper {

  @Insert("INSERT INTO STATION(station_id, name, hd_enabled, call_sign) VALUES (#{stationId}, #{name}, #{hdEnabled}, " +
      "#{callSign})")
  public int insert(Station station);

  @Delete("DELETE * FROM STATION WHERE ID = #{id}")
  public int deleteById(long id);

  @Update("UPDATE STATION SET NAME = #{name}, STATION_ID = #{stationId}, HD_ENABLED = #{hdEnabled}, CALL_SIGN = " +
      "#{callSign}")
  public int update(Station station);

  @Select("SELECT * FROM STATION WHERE STATION_ID = #{stationId}")
  public Station searchByStationId(String stationId);

  @Select("SELECT * FROM STATION WHERE NAME = #{name}")
  public Station searchByStationName(String name);

  @Select("SELECT * FROM STATION WHERE HD_ENABLED = '1'")
  public List<Station> searchHdEnabled();
}
