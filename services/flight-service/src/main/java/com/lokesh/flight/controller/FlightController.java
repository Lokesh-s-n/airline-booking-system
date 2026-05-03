package com.lokesh.flight.controller;

import com.lokesh.flight.model.Flight;
import com.lokesh.flight.service.FlightService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/flights")
public class FlightController {

    private final FlightService service;

    public FlightController(FlightService service) {
        this.service = service;
    }

    @PostMapping
    public Flight createFlight(@RequestBody Flight flight) {
        return service.saveFlight(flight);
    }

    @GetMapping
    public List<Flight> getAllFlights() {
        return service.getAllFlights();
    }
}