package com.example.travelcli.model;

import java.util.List;

public class Airport {
    private Long id;
    private String name;
    private City city; 
    private List<Aircraft> aircrafts;

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

    public List<Aircraft> getAircrafts() {
        return aircrafts; }
    public void setAircrafts(List<Aircraft> aircrafts) {
        this.aircrafts = aircrafts; }
}
