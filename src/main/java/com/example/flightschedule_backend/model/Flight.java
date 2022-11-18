package com.example.flightschedule_backend.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Flight implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String callsign;
    private String departureAirport;
    private String arrivalAirport;
    private Date timeOfDeparture;
    private Date timeOfArrival;
    private int distanceFromDepartureAirport;
    private int distanceFromＡrrivalAirport;

//    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean isReturnFlight;

    public Flight() {
    }

    public Flight(Long id, String callsign, String departureAirport, String arrivalAirport, Date timeOfDeparture, Date timeOfArrival, int distanceFromDepartureAirport, int distanceFromＡrrivalAirport, boolean isReturnFlight) {
        this.id = id;
        this.callsign = callsign;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.timeOfDeparture = timeOfDeparture;
        this.timeOfArrival = timeOfArrival;
        this.distanceFromDepartureAirport = distanceFromDepartureAirport;
        this.distanceFromＡrrivalAirport = distanceFromＡrrivalAirport;
        this.isReturnFlight = isReturnFlight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCallsign() {
        return callsign;
    }

    public void setCallsign(String callsign) {
        this.callsign = callsign;
    }

    public String getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(String departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(String arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Date getTimeOfDeparture() {
        return timeOfDeparture;
    }

    public void setTimeOfDeparture(Date timeOfDeparture) {
        this.timeOfDeparture = timeOfDeparture;
    }

    public Date getTimeOfArrival() {
        return timeOfArrival;
    }

    public void setTimeOfArrival(Date timeOfArrival) {
        this.timeOfArrival = timeOfArrival;
    }

    public int getDistanceFromDepartureAirport() {
        return distanceFromDepartureAirport;
    }

    public void setDistanceFromDepartureAirport(int distanceFromDepartureAirport) {
        this.distanceFromDepartureAirport = distanceFromDepartureAirport;
    }

    public int getDistanceFromＡrrivalAirport() {
        return distanceFromＡrrivalAirport;
    }

    public void setDistanceFromＡrrivalAirport(int distanceFromＡrrivalAirport) {
        this.distanceFromＡrrivalAirport = distanceFromＡrrivalAirport;
    }

    public boolean isReturnFlight() {
        return isReturnFlight;
    }

    public void setReturnFlight(boolean isReturnFlight) {
        this.isReturnFlight = isReturnFlight;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", callsign='" + callsign + '\'' +
                ", departureAirport='" + departureAirport + '\'' +
                ", arrivalAirport='" + arrivalAirport + '\'' +
                ", timeOfDeparture=" + timeOfDeparture +
                ", timeOfArrival=" + timeOfArrival +
                ", distanceFromDepartureAirport=" + distanceFromDepartureAirport +
                ", distanceFromＡrrivalAirport=" + distanceFromＡrrivalAirport +
                ", isReturnFlight=" + isReturnFlight +
                '}';
    }
}
