package com.example.hotelReservationSystem.repositories;

import com.example.hotelReservationSystem.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

}
