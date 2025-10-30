package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;
    Scanner scanner = new Scanner(System.in);

    public void display() throws IOException {
        init();

        boolean isDone = false;
        while (!isDone) {
            displayMenu();
            System.out.print("Enter command: ");
            String command = scanner.nextLine().toUpperCase();

            switch (command) {
                case "A":
                    processAllVehiclesRequest();
                    break;
                case "X":
                    System.out.println("Thank you for using this application");
                    isDone = true;
                    break;
                default:
                    System.out.println("Invalid input");
            }
        }
    }

    private void init() throws IOException {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.getDealership();
        System.out.println(dealership.getName() + "Application");
        System.out.println();
    }

    private void displayMenu() {
        System.out.println("A - List all vehicles");
        System.out.println("X - Quit");
        System.out.println();
    }

    private void processAllVehiclesRequest() {
        ArrayList<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    private void displayVehicles(ArrayList<Vehicle> vehicles) {
        if (vehicles == null || vehicles.isEmpty()) {
            System.out.println("No vehicles found.");
            return;
        }

        System.out.println("Inventory:");
        System.out.println("------------------------------------");
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle);
        }
    }
}