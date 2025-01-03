package com.example.hotelReservationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.hotelReservationSystem.entity")
public class HotelReservationSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(HotelReservationSystemApplication.class, args);
	}
}
