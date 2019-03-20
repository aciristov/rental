package com.example.jpa.service;

import com.example.jpa.model.City;
import com.example.jpa.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CityService {

    List<City> findAll();

    City save(City city);

    Optional<City> findById(Long id);

    void delete(City city);


}
