package com.example.travel_cli;

import java.util.Scanner;

import com.example.travel_cli.service.ApiService;

public class TravelCliApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiService apiService = new ApiService();

        while (true) {
            System.out.println("\n=== Travel CLI ===");
            System.out.println("1. List all cities");
            System.out.println("2. List all airports in a city");
            System.out.println("3. List all aircraft");
            System.out.println("4. List all passengers on an aircraft");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1 -> apiService.listCities();
                case 2 -> {
                    System.out.print("Enter city ID: ");
                    Long cityId = scanner.nextLong();
                    apiService.listAirportsByCity(cityId);
                }
                case 3 -> apiService.listAircraft();
                case 4 -> {
                    System.out.print("Enter aircraft ID: ");
                    Long aircraftId = scanner.nextLong();
                    apiService.listPassengersByAircraft(aircraftId);
                }
                case 0 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
