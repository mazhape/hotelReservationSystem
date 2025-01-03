package com.example.hotelReservationSystem.repositories;

import com.example.hotelReservationSystem.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, Long> {

}
