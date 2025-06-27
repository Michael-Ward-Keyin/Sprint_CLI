package com.example.travelcli;

import com.example.travelcli.model.*;
import com.example.travelcli.service.ApiService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Scanner;

public class TravelCliApp {
    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        ObjectMapper mapper = new ObjectMapper();
        String baseUrl = "http://localhost:8080"; // Update if needed

        ApiService apiService = new ApiService(client, mapper, baseUrl);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n=== Travel CLI Menu ===");
            System.out.println("1. List all cities");
            System.out.println("2. List all passengers");
            System.out.println("3. List all airports");
            System.out.println("4. List all aircraft");
            System.out.println("5. List airports by city ID");
            System.out.println("6. List passengers by aircraft ID");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1":
                        List<City> cities = apiService.listCities();
                        cities.forEach(city -> System.out.println("- " + city.getId() + ": " + city.getName()));
                        break;
                    case "2":
                        List<Passenger> passengers = apiService.listPassengers();
                        passengers.forEach(p -> System.out.println("- " + p.getId() + ": " + p.getName()));
                        break;
                    case "3":
                        List<Airport> airports = apiService.listAirports();
                        airports.forEach(a -> System.out.println("- " + a.getId() + ": " + a.getName()));
                        break;
                    case "4":
                        List<Aircraft> aircraft = apiService.listAircraft();
                        aircraft.forEach(a -> System.out.println("- " + a.getId() + ": " + a.getModel()));
                        break;
                    case "5":
                        System.out.print("Enter City ID: ");
                        Long cityId = Long.parseLong(scanner.nextLine());
                        List<Airport> filteredAirports = apiService.listAirportsByCity(cityId);
                        filteredAirports.forEach(a -> System.out.println("- " + a.getId() + ": " + a.getName()));
                        break;
                    case "6":
                        System.out.print("Enter Aircraft ID: ");
                        Long aircraftId = Long.parseLong(scanner.nextLine());
                        List<Passenger> filteredPassengers = apiService.listPassengersByAircraft(aircraftId);
                        filteredPassengers.forEach(p -> System.out.println("- " + p.getId() + ": " + p.getName()));
                        break;
                    case "0":
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
