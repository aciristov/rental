package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.Location;
import com.example.jpa.repository.CityRepository;
import com.example.jpa.repository.LocationRepository;
import com.example.jpa.service.CityService;
import com.example.jpa.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/locationAPI")
public class LocationController {

    @Autowired
    LocationService locationService;

    @Autowired
    CityService cityService;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    CityRepository cityRepository;

    @GetMapping("/locations")
    public Page<Location> getAllLocations(Pageable pageable){
        return locationService.findAll(pageable);
    }

    @PostMapping("/cities/{cityid}/locations")
    public Location createLocation(@PathVariable Long cityid, @Valid @RequestBody Location location){
        return cityService.findById(cityid).map(city -> {
            location.setCity(city);
            return locationService.save(location);
        }).orElseThrow(() -> new ResourceNotFoundException("City with " + cityid + " can't be found"));
    }

    @GetMapping("/cities/{cityid}/locations")
    public Page<Location> getAllLocationsByCityId(@PathVariable (value = "cityid") Long cityid,
                                                    Pageable pageable) {
        return locationService.findByCityId(cityid, pageable);
    }

    @GetMapping("/cities/{cityid}/locations/{locationid}")
    public ResponseEntity<Location> getLocationByCityId(@PathVariable Long locationid){
        Location location = locationRepository.findById(locationid).get();
        return ResponseEntity.ok().body(location);
    }

    @DeleteMapping("/cities/{cityid}/locations/{locationid}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long cityid,
                                           @PathVariable Long locationid){
        if (!cityRepository.existsById(cityid)){
            throw new ResourceNotFoundException("Cityid " + cityid + " not found");
        }

        return locationRepository.findById(locationid).map(location -> {
            locationRepository.delete(location);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Location with Id: " + locationid + " not found"));

    }

}
