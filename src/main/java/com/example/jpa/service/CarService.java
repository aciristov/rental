package com.example.jpa.service;

import com.example.jpa.model.Car;
import com.example.jpa.model.CarEquipmentPojos;
import com.example.jpa.model.CarPojos;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CarService {

    Page<Car> findAll(Pageable pageable);
    Page<Car> findByCategoryId(Long l, Pageable p);
    Optional<Car> findById(Long id);

    Car save(Car car);
    Car saveCar(CarPojos carPojos, Long categoryid);
    List<CarEquipmentPojos> getEquipment(Long carid);

    void update(Long id, Car car);
    void delete (Car c);

}
