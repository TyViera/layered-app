package com.travelport.layeredapp.repository;

import com.travelport.layeredapp.model.House;
import java.util.List;

public interface HouseRepository {
  List<House> getAll();

  House create(House house);
}
