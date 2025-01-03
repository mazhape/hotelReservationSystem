package com.example.hotelReservationSystem.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
public class RoomResponse {
    private Long roomId;
    private String type;
    private String roomNumber;
    private double price;
    private boolean isBooked;
    private String hotelName;
    private String details;
    private List<BookingResponse> bookings;



    public RoomResponse(Long roomId, String type, String roomNumber, double price, boolean isBooked, String hotelName, String details) {
        this.roomId = roomId;
        this.type = type;
        this.roomNumber = roomNumber;
        this.price = price;
    }

// Getters and Setters
public Long getRoomId() {
        return roomId;
}
    public void setRoomId(Long roomId) {
        this.roomId = roomId;
    }
    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
