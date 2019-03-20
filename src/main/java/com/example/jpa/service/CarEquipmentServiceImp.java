package com.example.jpa.service;

import com.example.jpa.model.CarEquipment;
import com.example.jpa.repository.CarEquipmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CarEquipmentServiceImp implements CarEquipmentService {

    @Autowired
    CarEquipmentRepository carEquipmentRepository;

    @Override
    public CarEquipment save(CarEquipment carEquipment) {
        return carEquipmentRepository.save(carEquipment);
    }

    @Override
    public List<CarEquipment> listAll() {
        return carEquipmentRepository.findAll();
    }

    @Override
    public CarEquipment getCar(Long id) {
        return carEquipmentRepository.findById(id).get();
    }

    @Override
    public void update(Long id, CarEquipment carEquipment) {
        carEquipmentRepository.save(carEquipment);
    }

    @Override
    public void delete(CarEquipment ce) {
        carEquipmentRepository.delete(ce);
    }
}
