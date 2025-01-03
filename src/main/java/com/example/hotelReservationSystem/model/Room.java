package com.example.hotelReservationSystem.model;

// Room.java
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.Map;

@Data
//@Entity
@Getter
@Setter
@AllArgsConstructor

public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String roomNumber;
    private String type; // e.g., Single, Double, Suite
    private double price;
    private Map<Date, Boolean> availability;

//    @ManyToOne(mappedBy = "room", fetch = FetchType.LAZY )
//    private Hotel hotel;

   public Room(String roomNumber, String type, double price, Map<Date, Boolean> availability) {
       this.roomNumber = roomNumber;
       this.type = type;
       this.price = price;
       this.availability = availability;
   }

   public Room() {}

    public Long  getId(){
       return id;
    }

    public String getRoomNumber(){
       return roomNumber;
    }
    public String getType(){
       return type;
    }
    public double getPrice(){
       return price;

    }
    public Map<Date, Boolean> getAvailability(){
       return availability;
    }
}
