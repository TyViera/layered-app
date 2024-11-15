package com.travelport.layeredapp.repository;

import com.travelport.layeredapp.model.House;
import java.util.List;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class HouseRepositoryImpl implements HouseRepository {

  private final JdbcTemplate jdbcTemplate;

  public HouseRepositoryImpl(JdbcTemplate jdbcTemplate) {
    this.jdbcTemplate = jdbcTemplate;
  }


  @Override
  public List<House> getAll() {
    return jdbcTemplate.query("select * from houses", (rs, row) -> {
      House house = new House();
      house.setAddress(rs.getString("address"));
      return house;
    });
  }

  @Override
  public House create(House house) {
    jdbcTemplate.update("insert into houses (address) values (?)", house.getAddress());
    return house;
  }

}
