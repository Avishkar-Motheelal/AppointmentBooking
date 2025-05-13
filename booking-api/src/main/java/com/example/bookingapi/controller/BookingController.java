package com.example.bookingapi.controller;

import com.example.bookingapi.model.BookingDTO;
import com.example.bookingapi.model.BookingModel;
import com.example.bookingapi.repository.BookingRepository;
import com.example.bookingapi.service.BoookingProcessorProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BookingController {

    private final BookingRepository bookingRepository;
    private final BoookingProcessorProducer boookingProcessorProducer;


    @GetMapping("/bookings")
    public List<BookingModel> getAllBookings() {
        return bookingRepository.findAll();
    }


    @PostMapping("/bookings")
    public BookingModel createBooking(@RequestBody BookingDTO booking) {
        BookingModel savedBooking = bookingRepository.save(booking.toModel());
        boookingProcessorProducer.sendBookingMessage(savedBooking);
        return savedBooking;
    }
}
