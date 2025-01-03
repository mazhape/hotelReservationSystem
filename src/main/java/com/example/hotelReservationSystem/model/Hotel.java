package com.example.hotelReservationSystem.model;

// Hotel.java
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String city;
}
