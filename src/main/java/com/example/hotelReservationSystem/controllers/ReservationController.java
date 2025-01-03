package com.example.hotelReservationSystem.controllers;

import com.example.hotelReservationSystem.model.Reservation;
import com.example.hotelReservationSystem.repositories.ReservationRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationRepository reservationRepository;
    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @GetMapping
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @PostMapping
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservationRepository.save(reservation);
    }
}
