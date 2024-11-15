package com.travelport.layeredapp.service;

import com.travelport.layeredapp.model.House;
import java.util.List;

public interface HouseService {
  List<House> getAll();

  House create(House house);
}
