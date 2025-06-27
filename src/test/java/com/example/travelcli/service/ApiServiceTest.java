package com.example.travelcli.service;

import com.example.travelcli.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class ApiServiceTest {

    private ApiService apiService;
    private HttpClient mockClient;
    private HttpResponse<String> mockResponse;

    @BeforeEach
    public void setup() {
        mockClient = Mockito.mock(HttpClient.class);
        mockResponse = Mockito.mock(HttpResponse.class);
        apiService = new ApiService(mockClient, new ObjectMapper(), "http://localhost:8080");
    }

    @Test
    public void testListCities_returnsParsedCities() throws Exception {
        String json = """
            [
              { "id": 1, "name": "Toronto" },
              { "id": 2, "name": "Halifax" }
            ]
            """;

        when(mockResponse.body()).thenReturn(json);
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        List<City> result = apiService.listCities();

        assertEquals(2, result.size());
        assertEquals("Toronto", result.get(0).getName());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void testListPassengers_returnsParsedPassengers() throws Exception {
        String json = """
            [
              { "id": 1, "name": "Alice" },
              { "id": 2, "name": "Bob" }
            ]
            """;

        when(mockResponse.body()).thenReturn(json);
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        List<Passenger> result = apiService.listPassengers();

        assertEquals(2, result.size());
        assertEquals("Alice", result.get(0).getName());
        assertEquals(2L, result.get(1).getId());
    }

    @Test
    public void testListAirports_returnsParsedAirports() throws Exception {
        String json = """
            [
              { "id": 1, "name": "Pearson Intl" },
              { "id": 2, "name": "Stanfield Intl" }
            ]
            """;

        when(mockResponse.body()).thenReturn(json);
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        List<Airport> result = apiService.listAirports();

        assertEquals(2, result.size());
        assertEquals("Pearson Intl", result.get(0).getName());
        assertEquals("Stanfield Intl", result.get(1).getName());
    }

    @Test
    public void testListAircraft_returnsParsedAircraft() throws Exception {
        String json = """
            [
              { "id": 1, "model": "Boeing 747" },
              { "id": 2, "model": "Airbus A320" }
            ]
            """;

        when(mockResponse.body()).thenReturn(json);
        when(mockResponse.statusCode()).thenReturn(200);
        when(mockClient.send(any(HttpRequest.class), eq(HttpResponse.BodyHandlers.ofString())))
                .thenReturn(mockResponse);

        List<Aircraft> result = apiService.listAircraft();

        assertEquals(2, result.size());
        assertEquals("Boeing 747", result.get(0).getModel());
        assertEquals("Airbus A320", result.get(1).getModel());
    }
}
