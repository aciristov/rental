package com.example.jpa.service;

import com.example.jpa.model.*;
import com.example.jpa.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImp implements CarService{

    @Autowired
    CarRepository carRepository;

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    CarEquipmentRepository carEquipmentRepository;

    @Autowired
    EquipmentRepository equipmentRepository;

    @Override
    public Page<Car> findAll(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Page<Car> findByCategoryId(Long l, Pageable p) {
        return carRepository.findByCategoryId(l, p);
    }

    @Override
    public Optional<Car> findById(Long id) {
        return carRepository.findById(id);
    }

    @Override
    public void update(Long id, Car car) {
        carRepository.save(car);
    }

    @Override
    public void delete(Car c) {
        carRepository.delete(c);
    }

    @Override
    public Car saveCar(CarPojos carPojos, Long categoryid) {
        Category category = categoryRepository.findById(categoryid).get();
        Car car = new Car();
        car.setMileage(carPojos.getMileage());
        car.setColor(carPojos.getColor());
        car.setCategory(category);

        car = carRepository.save(car);


        for (CarEquPojos c : carPojos.getEquipments()){
            CarEquipment o = new CarEquipment();
            o.setCarid(car.getId());
            o.setEquipmentid(c.getEquipmentid());
            o.setStart_date(c.getStart_date());
            o.setEnd_date(c.getEnd_date());

            carEquipmentRepository.save(o);

        }
        return car;
    }

    @Override
    public List<CarEquipmentPojos> getEquipment(Long carid) {
        List<CarEquipmentPojos> carEquipmentPojos = new ArrayList<>();
        List<CarEquipment> carEquipments = carEquipmentRepository.findByCarId(carid);

        for (CarEquipment carEquipment: carEquipments){
            Optional<Equipment> equipmentOptional = equipmentRepository.findById(carEquipment.getEquipmentid());
            equipmentOptional.ifPresent(equipment -> {
                CarEquipmentPojos carEquipmentPojos1 = new CarEquipmentPojos(
                        equipment.getId(),
                        equipment.getName(),
                        carEquipment.getStart_date(),
                        carEquipment.getEnd_date()
                );
                carEquipmentPojos.add(carEquipmentPojos1);
            });
        }
        return carEquipmentPojos;
    }
}
