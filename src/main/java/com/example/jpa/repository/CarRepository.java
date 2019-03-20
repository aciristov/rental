package com.example.jpa.repository;

import com.example.jpa.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car save(Car car);

    Page<Car> findByCategoryId(Long Categoryid, Pageable pageable);

    List<Car> findAll();

    Optional<Car> findById(Long id);

}
