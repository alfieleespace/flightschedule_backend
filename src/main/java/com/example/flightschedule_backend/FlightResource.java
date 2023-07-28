package com.example.flightschedule_backend;

import com.example.flightschedule_backend.model.Flight;
import com.example.flightschedule_backend.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/flight")
public class FlightResource {
    private final FlightService flightService;

    public FlightResource(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id) {
        Flight flight = flightService.findFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFLight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        Flight updateFlight = flightService.updateFlight(flight);
        return new ResponseEntity<>(updateFlight, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
