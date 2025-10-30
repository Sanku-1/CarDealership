package com.pluralsight;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    DealershipFileManager dealershipFileManager = new DealershipFileManager();
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
                case "P":
                    processGetByPriceRequest();
                    break;
                case "M":
                    processGetByMakeModelRequest();
                    break;
                case "Y":
                    processGetByYearRequest();
                    break;
                case "C":
                    processGetByColorRequest();
                    break;
                case "O":
                    processGetByMileageRequest();
                    break;
                case "T":
                    processGetByVehicleTypeRequest();
                    break;
                case "U":
                    processAddVehicleRequest();
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
        dealership = dealershipFileManager.getDealership();
        System.out.println(dealership.getName() + " Application");
        System.out.println();
    }

    private void displayMenu() {
        System.out.println("A - List all vehicles");
        System.out.println("P - List all vehicles in price range");
        System.out.println("M - List all vehicles with Make/Model");
        System.out.println("Y - List all vehicles in year range");
        System.out.println("C - List all vehicles with color");
        System.out.println("O - List all vehicles in odometer range");
        System.out.println("T - List all vehicles with vehicle type");
        System.out.println("U - Add a vehicle");
        System.out.println("R - Remove a vehicle");
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
            System.out.println(vehicle.toString());
        }
    }

    private void processGetByPriceRequest() {
        System.out.println("Please enter the desired price range:");
        System.out.println("Max price:");
        double maxPriceInput = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Min price:");
        double minPriceInput = scanner.nextDouble();
        scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByPrice(maxPriceInput, minPriceInput);
        displayVehicles(vehicles);
    }

    private void processGetByMakeModelRequest() {
        System.out.println("Please enter the desired make and model:");
        System.out.println("Make:");
        String makeInput = scanner.nextLine();
        System.out.println("Model");
        String modelInput = scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMakeModel(makeInput, modelInput);
        displayVehicles(vehicles);
    }

    private void processGetByYearRequest() {
        System.out.println("Please enter the desired year range:");
        System.out.println("Max year:");
        int maxYearInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Min year:");
        int minYearInput = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByYear(maxYearInput, minYearInput);
        displayVehicles(vehicles);
    }

    private void processGetByColorRequest() {
        System.out.println("Please enter the desired color:");
        String colorInput = scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByColor(colorInput);
        displayVehicles(vehicles);
    }

    private void processGetByMileageRequest() {
        System.out.println("Please enter the desired mileage range:");
        System.out.println("Max mileage:");
        int maxMileageInput = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Min mileage:");
        int minMileageInput = scanner.nextInt();
        scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByMileage(maxMileageInput, minMileageInput);
        displayVehicles(vehicles);
    }

    private void processGetByVehicleTypeRequest() {
        System.out.println("Please enter the desired vehicle type from the following options: (sedan, truck, SUV, van)");
        String vehicleTypeInput = scanner.nextLine();
        ArrayList<Vehicle> vehicles = dealership.getVehiclesByType(vehicleTypeInput);
        displayVehicles(vehicles);
    }

    private void processAddVehicleRequest() throws IOException {
        System.out.println("Please enter the VIN:");
        int vin = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the Year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the Make:");
        String make = scanner.nextLine();
        System.out.println("Please enter the Model:");
        String model = scanner.nextLine();
        System.out.println("Please enter the Vehicle Type:");
        String vehicleType = scanner.nextLine();
        System.out.println("Please enter the color:");
        String color = scanner.nextLine();
        System.out.println("Please enter the mileage:");
        int odometer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Please enter the price:");
        double price = scanner.nextDouble();
        Vehicle newVehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        dealership.addVehicle(newVehicle);
        dealershipFileManager.saveDealership(dealership);
    }

//    private void processRemoveVehicleRequest() {
//        ArrayList<Vehicle> vehicles = dealership.();
//        displayVehicles(vehicles);
//    }
}