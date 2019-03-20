package com.example.jpa.repository;

import com.example.jpa.model.CarEquipment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CarEquipmentRepository extends JpaRepository<CarEquipment, Long> {
    Page<CarEquipment> findByEquipmentId(Long equipmentid, Pageable pageable);
    List<CarEquipment> findByCarId(Long carid);
    Optional<CarEquipment> findById(Long id);
}
