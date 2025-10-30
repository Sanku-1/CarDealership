package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;
    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone, ArrayList<Vehicle> inventory) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public static ArrayList<Vehicle> getVehiclesByPrice(double max, double min) {
        return null;
    }

    public static ArrayList<Vehicle> getVehiclesByMakeModel(String make, String model) {
        return null;
    }

    public static ArrayList<Vehicle> getVehiclesByYear(int max, int min) {
        return null;
    }

    public static ArrayList<Vehicle> getVehiclesByColor(String color) {
        return null;
    }

    public static ArrayList<Vehicle> getVehiclesByMileage(int max, int min) {
        return null;
    }

    public static ArrayList<Vehicle> getVehiclesByType(String vehicleType) {
        return null;
    }

    public static ArrayList<Vehicle> getAllVehicles() {
        return null;
    }

    public static void addVehicle(Vehicle vehicle) {

    }

    public static void removeVehicle(Vehicle vehicle) {

    }
}


