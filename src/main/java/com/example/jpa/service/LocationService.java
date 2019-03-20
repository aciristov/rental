package com.example.jpa.service;

import com.example.jpa.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;


public interface LocationService {

    Page<Location> findAll(Pageable pageable);

    Location save(Location location);

    Page<Location> findByCityId(Long l, Pageable p);

    Optional<Location> findById(Long id);

}
