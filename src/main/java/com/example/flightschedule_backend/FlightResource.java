package com.example.flightschedule_backend;

import com.example.flightschedule_backend.model.Flight;
import com.example.flightschedule_backend.service.FlightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
// By default, @CrossOrigin won't enable Delete method. https://stackoverflow.com/questions/43166984/delete-method-cors-issue-in-rest-controller
//@CrossOrigin(origins = "*")
// @RequestMapping gives the whole class a default or base url
@RequestMapping("/flight")
public class FlightResource {
    private final FlightService flightService;

    public FlightResource(FlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/all")
    // Use generic class ResponseEntity so this method can return a http response, and the body of this http response will be a list of flights
    public ResponseEntity<List<Flight>> getAllFlights() {
        List<Flight> flights = flightService.findAllFlights();
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    // Use generic class ResponseEntity so this method can return a http response
    public ResponseEntity<Flight> getFlightById(@PathVariable("id") Long id) {
        Flight flight = flightService.findFlightById(id);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @PostMapping("/add")
    // Whatever is coming in from body of the request is a flight
    // By default route /add would accept json data 55:16 https://www.youtube.com/watch?v=Gx4iBLKLVHk
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        Flight newFlight = flightService.addFLight(flight);
        return new ResponseEntity<>(newFlight, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    // Use generic class ResponseEntity so this method can return a http response
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        Flight updateFlight = flightService.updateFlight(flight);
        return new ResponseEntity<>(updateFlight, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    // Use ? because this function doesn't return anything
    public ResponseEntity<?> deleteFlight(@PathVariable("id") Long id) {
        flightService.deleteFlight(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
