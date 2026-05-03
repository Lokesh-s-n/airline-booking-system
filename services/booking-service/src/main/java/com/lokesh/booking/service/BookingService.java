package com.lokesh.booking.service;

import com.lokesh.booking.dto.SeatResponse;
import com.lokesh.booking.model.Booking;
import com.lokesh.booking.repository.BookingRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository repository;
    private final WebClient.Builder webClientBuilder;

    public BookingService(BookingRepository repository, WebClient.Builder webClientBuilder) {
        this.repository = repository;
        this.webClientBuilder = webClientBuilder;
    }
    public List<Booking> getAllBookings() {
        return repository.findAll();
    }

//    public Booking bookFlight(Booking booking) {
//
//        List<SeatResponse> seats = webClientBuilder.build()
//                .get()
//                .uri("http://seat-service/api/seats?flightNumber={flight}",
//                        booking.getFlightNumber())
//                .retrieve()
//                .bodyToFlux(SeatResponse.class)
//                .collectList()
//                .block();
//
//        if (seats != null && seats.size() >= booking.getSeatsBooked()) {
//            booking.setStatus("CONFIRMED");
//            return repository.save(booking);
//        } else {
//            booking.setStatus("FAILED");
//            return booking;
//        }
//    }
public Booking bookFlight(Booking booking) {

    Boolean reserved = webClientBuilder.build()
            .post()
            .uri("http://seat-service/api/seats/reserve?flightNumber={flight}&count={count}",
                    booking.getFlightNumber(),
                    booking.getSeatsBooked())
            .retrieve()
            .bodyToMono(Boolean.class)
            .block();

    if (Boolean.TRUE.equals(reserved)) {
        booking.setStatus("CONFIRMED");
        return repository.save(booking);
    } else {
        booking.setStatus("FAILED");
        return booking;
    }
}
}