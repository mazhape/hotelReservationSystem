package com.example.hotelReservationSystem.service;

import java.util.List;

import com.example.hotelReservationSystem.entity.BookedRoom;
import com.example.hotelReservationSystem.entity.Room;
import com.example.hotelReservationSystem.repositories.BookingRepository;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    private final RoomService roomService;

    public List<BookedRoom> getAllBookings() {
        return bookingRepository.findAll();
    }

    public void cancelBooking(Long bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    public String saveBooking(Long roomId, BookedRoom bookingRequest) {
        if (bookingRequest.getCheckOutDate().isBefore(bookingRequest.getCheckInDate())) {
            throw new RuntimeException("Please provide valid date");
        }

        Room room = roomService.getRoomById(roomId).get();
        List<BookedRoom> existingBookings = room.getBookings();

        if (!roomIsAvailable(bookingRequest, existingBookings)) {
            throw new RuntimeException("Booking is not available for the selected dates.");
        }
        room.addBooking(bookingRequest);
        bookingRepository.save(bookingRequest);

        return bookingRequest.getBookingConfirmationCode();
    }

    public List<BookedRoom> getAllBookingsByRoomId(Long roomId) {
        return bookingRepository.findByRoomId(roomId);
    }

    private boolean roomIsAvailable(BookedRoom bookingRequest, List<BookedRoom> existingBookings) {
      return existingBookings.stream()
              .noneMatch(existingBooking ->
                      bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckInDate())
              ||bookingRequest.getCheckOutDate().isBefore(existingBooking.getCheckOutDate())
              || (bookingRequest.getCheckInDate().isAfter(existingBooking.getCheckInDate())
              && bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckOutDate()))
              || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

              && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckOutDate()))
              || (bookingRequest.getCheckInDate().isBefore(existingBooking.getCheckInDate())

              && bookingRequest.getCheckOutDate().isAfter(existingBooking.getCheckOutDate()))

              || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
              && bookingRequest.getCheckOutDate().equals(existingBooking.getCheckInDate()))

              || (bookingRequest.getCheckInDate().equals(existingBooking.getCheckOutDate())
              && bookingRequest.getCheckOutDate().equals(bookingRequest.getCheckInDate())));
    }
}
