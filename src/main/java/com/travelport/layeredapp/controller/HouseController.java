package com.travelport.layeredapp.controller;

import com.travelport.layeredapp.model.House;
import com.travelport.layeredapp.service.HouseService;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/houses")
public class HouseController {

  private final HouseService houseService;

  public HouseController(HouseService jdbcTemplate) {
    this.houseService = jdbcTemplate;
  }

  @GetMapping
  public List<House> getAll() {
    return houseService.getAll();
  }

  @PostMapping
  public House createHouse(House house) {
    houseService.create(house);
    return house;
  }

}
