package com.example.jpa.service;

import com.example.jpa.model.CarEquipment;

import java.util.List;

public interface CarEquipmentService {
    CarEquipment save(CarEquipment carEquipment);
    List<CarEquipment> listAll();
    CarEquipment getCar(Long id);
    void update(Long id, CarEquipment carEquipment);
    void delete(CarEquipment o);
}
