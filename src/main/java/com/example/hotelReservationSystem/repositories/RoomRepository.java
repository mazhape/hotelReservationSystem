package com.example.hotelReservationSystem.repositories;

import com.example.hotelReservationSystem.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;


public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findAvailableRoomsByDatesAndType(LocalDate checkInDate, LocalDate checkOutDate, String type, String roomNumber, Double price);
}
