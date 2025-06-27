package com.example.travelcli.service;

import com.example.travelcli.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class ApiService {
    private final HttpClient client;
    private final ObjectMapper objectMapper;
    private final String baseUrl;

    public ApiService(HttpClient client, ObjectMapper objectMapper, String baseUrl) {
        this.client = client;
        this.objectMapper = objectMapper;
        this.baseUrl = baseUrl;
    }

    public List<City> listCities() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/cities"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, City.class));
    }

    public List<Passenger> listPassengers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/passengers"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }

    public List<Airport> listAirports() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/airports"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public List<Aircraft> listAircraft() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/aircraft"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Aircraft.class));
    }

    public List<Airport> listAirportsByCity(Long cityId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/cities/" + cityId + "/airports"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public List<Passenger> listPassengersByAircraft(Long aircraftId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/aircraft/" + aircraftId + "/passengers"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }
}