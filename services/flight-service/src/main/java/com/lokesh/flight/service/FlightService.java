package com.lokesh.flight.service;

import com.lokesh.flight.model.Flight;
import com.lokesh.flight.repository.FlightRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final FlightRepository repository;

    public FlightService(FlightRepository repository) {
        this.repository = repository;
    }

    public Flight saveFlight(Flight flight) {
        return repository.save(flight);
    }

    public List<Flight> getAllFlights() {
        return repository.findAll();
    }
}