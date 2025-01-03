package com.example.hotelReservationSystem.model;

// Reservation.java
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private String customerName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private String userName;
    private Hotel hotel;
    private Room room;
}
