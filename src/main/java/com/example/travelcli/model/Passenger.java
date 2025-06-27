package com.example.travelcli.model;

import java.util.List;

public class Passenger {
    private Long id;
    private String name;
    private City city;
    private List<Aircraft> aircraft;

    public Long getId() { 
        return id; }
    public void setId(Long id) { 
        this.id = id; }

    public String getName() { 
        return name; }
    public void setName(String name) { 
        this.name = name; }

    public City getCity() { 
        return city; }
    public void setCity(City city) { 
        this.city = city; }

    public List<Aircraft> getAircraft() { 
        return aircraft; }
    public void setAircraft(List<Aircraft> aircraft) { 
        this.aircraft = aircraft; }
}
