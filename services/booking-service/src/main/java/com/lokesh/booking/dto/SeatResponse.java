package com.lokesh.booking.dto;

public class SeatResponse {

    private String flightNumber;
    private String seatNumber;

    // getters
    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    // setters
    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }
}