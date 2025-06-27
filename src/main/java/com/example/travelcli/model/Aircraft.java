package com.example.travelcli.model;

import java.util.List;

public class Aircraft {
    private Long id;
    private String model;
    private List<Airport> airports;
    private List<Passenger> passengers;

    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }

    public String getModel() {
        return model; }
    public void setModel(String model) {
        this.model = model; }

    public List<Airport> getAirports() {
        return airports; }
    public void setAirports(List<Airport> airports) {
        this.airports = airports; }

    public List<Passenger> getPassengers() {
        return passengers; }
    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers; }
}
