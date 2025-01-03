package com.example.hotelReservationSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.hotelReservationSystem.entity.BookedRoom;


public interface BookingRepository extends JpaRepository<BookedRoom, Long> {

    List<BookedRoom> findByRoomId(Long roomId);
}