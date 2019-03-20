package com.example.jpa.controller;

import com.example.jpa.model.Reservation;
import com.example.jpa.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservationAPI")
public class ReservationController {

    @Autowired
    ReservationService reservationService;

    @GetMapping("/reservations")
    public Page<Reservation> getAllReservations(Pageable pageable)
    {
        return reservationService.findAll(pageable);
    }


}
