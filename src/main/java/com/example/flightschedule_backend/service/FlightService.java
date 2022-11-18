package com.example.flightschedule_backend.service;

import com.example.flightschedule_backend.exception.FlightNotFoundException;
import com.example.flightschedule_backend.model.Flight;
import com.example.flightschedule_backend.repo.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
// https://stackoverflow.com/questions/32269192/spring-no-entitymanager-with-actual-transaction-available-for-current-thread
@Transactional
public class FlightService {
    private final FlightRepo flightRepo;
    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public Flight addFLight(Flight flight) {
        return flightRepo.save(flight);
    }

    public List<Flight> findAllFlights() {
        return flightRepo.findAll();
    }

    public Flight updateFlight(Flight flight) {
        return flightRepo.save(flight);
    }

    public Flight findFlightById(Long id) {
        return flightRepo.findFlightById(id)
                .orElseThrow(() -> new FlightNotFoundException("Flight by id" + id + "was not found"));
    }

    public void deleteFlight(Long id) {
        flightRepo.deleteFlightById(id);
    }
}
