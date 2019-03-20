package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.City;
import com.example.jpa.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/cityAPI")
public class CityController {

    @Autowired
    CityService cityService;

    @GetMapping(value = "/cities")
    public List<City> getAllCities(){
        return cityService.findAll();
    }

    @PostMapping("/cities")
    public City createCity(@Valid @RequestBody City city){
        return cityService.save(city);
    }

    @PutMapping("/cities/{cityid}")
    public City updateCity(@PathVariable Long cityid, @Valid @RequestBody City cityRequest) {
        return cityService.findById(cityid).map(city -> {
            city.setName(cityRequest.getName());
            return cityService.save(city);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + cityid + " not found"));
    }

    @DeleteMapping("/cities/{cityid}")
    public ResponseEntity<?> deleteCity(@PathVariable Long cityid) {
        return cityService.findById(cityid).map(city -> {
            cityService.delete(city);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + cityid + " not found"));
    }

}
