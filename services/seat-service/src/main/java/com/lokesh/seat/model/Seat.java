package com.lokesh.seat.model;

import jakarta.persistence.*;

@Entity
public class Seat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private int totalSeats;
    private int availableSeats;

    public Seat() {}

    public Seat(Long id, String flightNumber, int totalSeats, int availableSeats) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.totalSeats = totalSeats;
        this.availableSeats = availableSeats;
    }

    // getters
    public Long getId() { return id; }
    public String getFlightNumber() { return flightNumber; }
    public int getTotalSeats() { return totalSeats; }
    public int getAvailableSeats() { return availableSeats; }

    // setters
    public void setId(Long id) { this.id = id; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }
    public void setTotalSeats(int totalSeats) { this.totalSeats = totalSeats; }
    public void setAvailableSeats(int availableSeats) { this.availableSeats = availableSeats; }
}