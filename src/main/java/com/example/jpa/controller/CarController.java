package com.example.jpa.controller;

import com.example.jpa.exception.ResourceNotFoundException;
import com.example.jpa.model.Car;
import com.example.jpa.repository.CarRepository;
import com.example.jpa.repository.CategoryRepository;
import com.example.jpa.service.CarService;
import com.example.jpa.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/carAPI")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CarRepository carRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/cars")
    public Page<Car> getAllCars(Pageable pageable){
        return carRepository.findAll(pageable);
    }

    @PostMapping("/categories/{categoryid}/cars")
    public Car createCar(@PathVariable Long categoryid, @Valid @RequestBody Car car){
        return categoryService.findById(categoryid).map(category -> {
            car.setCategory(category);
            return carService.save(car);
        }).orElseThrow(() -> new ResourceNotFoundException("Category with " + categoryid + " can't be found"));
    }

    @GetMapping("/categories/{categoryid}/cars")
    public Page<Car> getAllCarsByCategoryId(@PathVariable (value = "categoryid") Long categoryid,
                                            Pageable pageable){
        return carService.findByCategoryId(categoryid, pageable);
    }

    @GetMapping("/categories/{categoryid}/cars/{carid}")
    public ResponseEntity<Car> getLocationByCityId(@PathVariable Long carid){
        Car car = carService.findById(carid).get();
        return ResponseEntity.ok().body(car);
    }

    @DeleteMapping("/categories/{categoryid}/cars/{carid}")
    public ResponseEntity<?> deleteCar(@PathVariable Long categoryid,
                                           @PathVariable Long carid){
        if (!categoryRepository.existsById(categoryid)){
            throw new ResourceNotFoundException("Category with id " + categoryid + " can't be found");
        }

        return carRepository.findById(carid).map(car -> {
            carRepository.delete(car);
            return ResponseEntity.ok().build();
        }).orElseThrow(()-> new ResourceNotFoundException("Car with Id: " + carid + " not found"));

    }

}
