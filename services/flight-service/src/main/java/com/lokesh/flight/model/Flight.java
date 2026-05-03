package com.lokesh.flight.model;

import jakarta.persistence.*;

@Entity
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String flightNumber;
    private String source;
    private String destination;
    private double price;

    public Flight() {}

    public Flight(Long id, String flightNumber, String source, String destination, double price) {
        this.id = id;
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getFlightNumber() { return flightNumber; }
    public void setFlightNumber(String flightNumber) { this.flightNumber = flightNumber; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }
}