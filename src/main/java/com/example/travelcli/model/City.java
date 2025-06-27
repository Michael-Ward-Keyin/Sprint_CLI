package com.example.travelcli.model;

import java.util.List;

public class City {
    private Long id;
    private String name;
    private List<Airport> airports;

    public Long getId() {
        return id; }
    public void setId(Long id) {
        this.id = id; }

    public String getName() {
        return name; }
    public void setName(String name) {
        this.name = name; }

    public List<Airport> getAirports() {
        return airports; }
    public void setAirports(List<Airport> airports) {
        this.airports = airports; }
}
