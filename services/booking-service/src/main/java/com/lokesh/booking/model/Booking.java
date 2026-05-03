package com.lokesh.booking.model;

import jakarta.persistence.*;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private int seatsBooked;
    private String status;

    public Booking() {}

    public Booking(Long id, String flightNumber, int seatsBooked, String status) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.seatsBooked = seatsBooked;
        this.status = status;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public int getSeatsBooked() { return seatsBooked; }
    public void setSeatsBooked(int seatsBooked) { this.seatsBooked = seatsBooked; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}