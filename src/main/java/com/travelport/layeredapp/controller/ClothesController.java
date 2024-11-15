package com.travelport.layeredapp.controller;

import com.travelport.layeredapp.model.Clothes;
import jakarta.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.io.FileUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clothes")
public class ClothesController {


  private final Map<String, Clothes> clothesList = new HashMap<>();

  @GetMapping
  public ResponseEntity<Collection<Clothes>> getAll() {
    return ResponseEntity.ok(clothesList.values());
  }

  @PostMapping
  public ResponseEntity<Clothes> createClothes(@Valid @RequestBody Clothes clothes) throws IOException {
    FileUtils.write(new File("log/clothes-creation-log.txt"), clothes.toString(), StandardCharsets.UTF_8, true);
    if (clothes.getId() == null) {
      clothes.setId(UUID.randomUUID().toString());
    } else if (clothesList.containsKey(clothes.getId())) {
      FileUtils.write(new File("log/clothes-creation-log.txt"), "Clothes %s already exists".formatted(clothes.getId()), StandardCharsets.UTF_8, true);
      var clothesResponse = new Clothes();
      clothesResponse.setErrorMessage("Clothes with id %s already exists".formatted(clothes.getId()));
      return ResponseEntity.badRequest().body(clothesResponse);
    }
    clothesList.put(clothes.getId(), clothes);
    return ResponseEntity.ok(clothes);
  }

  @PostMapping("/{id}")
  public ResponseEntity<Clothes> updateClothes(@PathVariable String id, @Valid @RequestBody Clothes clothes) throws IOException {
    FileUtils.write(new File("log/clothes-update-log.txt"), "Updating clothes with id: %s and new values: %s".formatted(id, clothes), StandardCharsets.UTF_8, true);
    if (!clothesList.containsKey(id)) {
      FileUtils.write(new File("log/clothes-update-log.txt"), "Clothes %s was not found".formatted(id), StandardCharsets.UTF_8, true);
      return ResponseEntity.notFound().build();
    }
    clothesList.put(id, clothes);
    return ResponseEntity.ok(clothes);
  }

}
