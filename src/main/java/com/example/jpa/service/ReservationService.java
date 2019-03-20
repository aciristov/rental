package com.example.jpa.service;

import com.example.jpa.model.Location;
import com.example.jpa.model.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {

    Page<Reservation> findAll(Pageable pageable);

    Reservation save(Reservation reservation);

    Optional<Reservation> findById(Long id);

    void delete(Reservation reservation);

}
