package com.travelport.layeredapp.repository.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class HouseEntity {

  @Id
  private String id;
  private String address;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
}
