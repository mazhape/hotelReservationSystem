package com.example.hotelReservationSystem.controllers;

import com.example.hotelReservationSystem.entity.RoomResponse;
import com.example.hotelReservationSystem.entity.Room;
import com.example.hotelReservationSystem.repositories.RoomRepository;
import com.example.hotelReservationSystem.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")

public class RoomController {
    private final RoomService roomService;
    private final RoomRepository roomRepository;

    @PostMapping("/add/new-room")
    public ResponseEntity<RoomResponse> addNewRoom(
            @RequestParam("type") String type,
            @RequestParam("roomNumber") String roomNumber,
            @RequestParam("price") double price) throws SQLException, IOException {
        Room savedRoom = roomService.addNewRoom(type, roomNumber, price);

        RoomResponse response = new RoomResponse();
        // Populate RoomResponse as per your requirements
        response.setRoomId(savedRoom.getId());
        response.setRoomNumber(savedRoom.getRoomNumber());
        response.setType(savedRoom.getType());
        response.setPrice(savedRoom.getPrice());

        return ResponseEntity.ok(response);
    }
    @GetMapping("/available-rooms")
    public ResponseEntity<List<RoomResponse>> getAvailableRooms(
            @RequestParam("checkInDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkInDate,
            @RequestParam("checkOutDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate checkOutDate,
            @RequestParam("roomType") String roomType) throws SQLException {

        List<Room> availableRooms = roomService.getAvailableRooms(checkInDate, checkOutDate, roomType);
        List<RoomResponse> roomResponses = new ArrayList<>();

        for (Room room : availableRooms) {
            RoomResponse response = new RoomResponse();
            response.setRoomId(room.getId());
            response.setRoomNumber(room.getRoomNumber());
            response.setType(room.getType());
            response.setPrice(room.getPrice());
            roomResponses.add(response);
        }

        if (roomResponses.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(roomResponses);
    }


    private RoomResponse getRoomResponse(Room room) {

        return null;
    }
}
