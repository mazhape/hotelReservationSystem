package com.example.hotelReservationSystem.service;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.example.hotelReservationSystem.entity.Room;
import com.example.hotelReservationSystem.repositories.RoomRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor

public class RoomService {
    private final RoomRepository roomRepository;

    public  Room addNewRoom(String roomNumber, String type, Double price)throws SQLException, IOException{
        Room room = new Room();
        room.setRoomNumber(roomNumber);
        room.setType(type);
        room.setPrice(price);

        return roomRepository.save(room);

    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }
    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String type, String roomNumber, Double price ) {
        return roomRepository.findAvailableRoomsByDatesAndType(checkInDate, checkOutDate, type,roomNumber,price);
    }

    public Optional<Room> getRoomById(Long Id) {
        return Optional.of(roomRepository.findById(Id).get());
    }


    public List<Room> getAvailableRooms(LocalDate checkInDate, LocalDate checkOutDate, String roomType) {
        return List.of();
    }
}
