package com.lokesh.seat.repository;

import com.lokesh.seat.model.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SeatRepository extends JpaRepository<Seat, Long> {

    Optional<Seat> findByFlightNumber(String flightNumber);
}