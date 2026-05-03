package com.lokesh.seat.controller;

import com.lokesh.seat.model.Seat;
import com.lokesh.seat.service.SeatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/seats")
public class SeatController {

    private final SeatService service;

    public SeatController(SeatService service) {
        this.service = service;
    }

    // ✅ Create
    @PostMapping
    public Seat createSeat(@RequestBody Seat seat) {
        return service.saveSeat(seat);
    }

    // ✅ Get all
    @GetMapping
    public List<Seat> getAllSeats() {
        return service.getAllSeats();
    }

    // ✅ Get by flight
    @GetMapping("/{flightNumber}")
    public Seat getSeatByFlight(@PathVariable String flightNumber) {
        return service.getSeatByFlight(flightNumber);
    }

    // 🔥 Reserve seats
    @PostMapping("/reserve")
    public boolean reserveSeats(@RequestParam String flightNumber,
                                @RequestParam int count) {
        return service.reserveSeats(flightNumber, count);
    }
}