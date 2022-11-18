package com.example.flightschedule_backend.repo;

import com.example.flightschedule_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// data type of the primary key is String
public interface FlightRepo extends JpaRepository<Flight, String> {
    void deleteFlightById(Long id);

    Optional<Flight> findFlightById(Long id);
}
