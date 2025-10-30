package com.pluralsight;

import java.io.*;
import java.util.ArrayList;

public class DealershipFileManager {
    public Dealership getDealership() throws IOException {
            FileReader fileReader = new FileReader("dealership.csv");
            BufferedReader inventoryBufReader = new BufferedReader(fileReader);
            String firstLine = inventoryBufReader.readLine();
            String[] dealershipTokens = firstLine.split("\\|");
            String name = dealershipTokens[0];
            String address = dealershipTokens[1];
            String phone = dealershipTokens[2];
            String line;
            Dealership dealership = new Dealership(name, address, phone);
            while ((line = inventoryBufReader.readLine()) != null) {
                String[] tokens = line.split("\\|");
                int vin = Integer.parseInt(tokens[0]);
                int year = Integer.parseInt(tokens[1]);
                String make = tokens[2];
                String model = tokens[3];
                String vehicleType = tokens[4];
                String color = tokens[5];
                int odometer = Integer.parseInt(tokens[6]);
                double price = Double.parseDouble(tokens[7]);
                Vehicle vehicle  = new Vehicle (vin, year, make, model, vehicleType, color, odometer, price);
                dealership.addVehicle(vehicle);
            }
            return dealership;
    }

    public void saveDealership(Dealership dealership) throws IOException {
        FileWriter fileWriter = new FileWriter("dealership.csv");
        BufferedWriter dealershipBufWriter = new BufferedWriter(fileWriter);
        dealershipBufWriter.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone() + "\n");
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            dealershipBufWriter.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" + vehicle.getModel() + "|" + vehicle.getVehicleType()+ "|" + vehicle.getColor() + "|" + vehicle.getOdometer() + "|" + vehicle.getPrice() + "\n");
        }
        dealershipBufWriter.close();
        fileWriter.close();
    }
}
