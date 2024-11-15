package com.travelport.layeredapp.service;

import com.travelport.layeredapp.model.House;
import com.travelport.layeredapp.repository.HouseRepository;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class HouseServiceImpl implements HouseService {

  private final HouseRepository dataOperations;

  public HouseServiceImpl(HouseRepository dataOperations) {
    this.dataOperations = dataOperations;
  }


  @Override
  public List<House> getAll() {
    return dataOperations.getAll();
  }

  @Override
  public House create(House house) {
    // Validar que no exista otra casa en la misma direccion
    if (addressExists()) {
      throw new IllegalArgumentException("Address already exists");
    }
    // Guardar la casa
    dataOperations.create(house);
    return house;
  }

  private boolean addressExists() {
    return Math.random() < 0.5;
  }

}
