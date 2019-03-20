package com.example.jpa.repository;

import com.example.jpa.model.Location;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    Page<Location> findByCityId(Long cityid, Pageable pageable);

    List<Location> findAll();

}
