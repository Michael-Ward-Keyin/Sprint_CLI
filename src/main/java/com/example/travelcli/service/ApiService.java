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

        System.out.println("DEBUG: Status /cities = " + response.statusCode());
        System.out.println("DEBUG: Body /cities = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, City.class));
    }

    public List<Passenger> listPassengers() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/passengers"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DEBUG: Status /passengers = " + response.statusCode());
        System.out.println("DEBUG: Body /passengers = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }

    public List<Airport> listAirports() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/airports"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DEBUG: Status /airports = " + response.statusCode());
        System.out.println("DEBUG: Body /airports = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public List<Aircraft> listAircraft() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/aircraft"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DEBUG: Status /aircraft = " + response.statusCode());
        System.out.println("DEBUG: Body /aircraft = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Aircraft.class));
    }

    public List<Airport> listAirportsByCity(Long cityId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/cities/" + cityId + "/airports"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DEBUG: Status /cities/" + cityId + "/airports = " + response.statusCode());
        System.out.println("DEBUG: Body /cities/" + cityId + "/airports = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Airport.class));
    }

    public List<Passenger> listPassengersByAircraft(Long aircraftId) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(baseUrl + "/aircraft/" + aircraftId + "/passengers"))
                .GET()
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("DEBUG: Status /aircraft/" + aircraftId + "/passengers = " + response.statusCode());
        System.out.println("DEBUG: Body /aircraft/" + aircraftId + "/passengers = " + response.body());

        return objectMapper.readValue(response.body(),
                objectMapper.getTypeFactory().constructCollectionType(List.class, Passenger.class));
    }
}
