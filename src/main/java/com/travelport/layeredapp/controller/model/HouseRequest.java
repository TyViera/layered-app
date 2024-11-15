package com.travelport.layeredapp.controller.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class HouseRequest {

  @NotNull
  private String id;
  @Pattern(regexp = "[a-zA-Z]{20} [0-9]{3}")
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
