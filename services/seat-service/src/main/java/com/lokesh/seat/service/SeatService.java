package com.lokesh.seat.service;

import com.lokesh.seat.model.Seat;
import com.lokesh.seat.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeatService {

    private final SeatRepository repository;

    public SeatService(SeatRepository repository) {
        this.repository = repository;
    }

    // ✅ Create seat record
    public Seat saveSeat(Seat seat) {
        return repository.save(seat);
    }

    // ✅ Get all
    public List<Seat> getAllSeats() {
        return repository.findAll();
    }

    // ✅ Get by flight (FIXED)
    public Seat getSeatByFlight(String flightNumber) {
        return repository.findByFlightNumber(flightNumber)
                .orElseThrow(() -> new RuntimeException("Flight not found"));
    }

    // 🔥 CORE LOGIC (FIXED)
    public boolean reserveSeats(String flightNumber, int count) {

        Seat seat = repository.findByFlightNumber(flightNumber)
                .orElse(null);

        if (seat == null) {
            return false;
        }

        if (seat.getAvailableSeats() < count) {
            return false;
        }

        // reduce available seats
        seat.setAvailableSeats(seat.getAvailableSeats() - count);
        repository.save(seat);

        return true;
    }

}