package com.lokesh.booking.controller;

import com.lokesh.booking.model.Booking;
import com.lokesh.booking.service.BookingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    public Booking book(@RequestBody Booking booking) {
        return service.bookFlight(booking);
    }
    @GetMapping
    public List<Booking> getAllBookings() {
        return service.getAllBookings();
    }
}