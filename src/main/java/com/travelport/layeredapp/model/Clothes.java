package com.travelport.layeredapp.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.util.Objects;

public class Clothes {

  private String errorMessage;

  private String id;

  @NotNull
  @Size(min = 1, max = 100)
  private String name;

  @NotNull
  private SizeEnum size;

  @NotNull
  @Min(0)
  @Max(1_000_000)
  private Double price;

  public enum SizeEnum {
    SMALL, MEDIUM, LARGE;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public SizeEnum getSize() {
    return size;
  }

  public void setSize(SizeEnum size) {
    this.size = size;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Clothes clothes)) return false;
    return Objects.equals(id, clothes.id);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(id);
  }

  @Override
  public String toString() {
    return "Clothes{" +
        "errorMessage='" + errorMessage + '\'' +
        ", id='" + id + '\'' +
        ", name='" + name + '\'' +
        ", size=" + size +
        ", price=" + price +
        '}';
  }
}
