package com.pluralsight.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class ContractDataManager {
    public static void saveContract(Contract contract) {
        try {
            FileWriter fileWriter = new FileWriter("contracts.csv", true);
            BufferedWriter contractBufferedWriter = new BufferedWriter(fileWriter);

            String contractLine = "";
            Vehicle vehicle = contract.getVehicleSold();

            if (contract instanceof SalesContract) {
                SalesContract salesContract = (SalesContract) contract;

                String financeOption = "No";
                if (salesContract.isFinanced()) {
                    financeOption = "Yes";
                }

                contractLine = "Sale|" +
                        salesContract.getDateOfContract() + "|" +
                        salesContract.getCustomerName() + "|" +
                        salesContract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        String.format("%.2f", vehicle.getPrice()) + "|" +
                        String.format("%.2f", salesContract.getSalesTaxAmount()) + "|" +
                        String.format("%.2f", salesContract.getRecordingFee()) + "|" +
                        String.format("%.2f", salesContract.getProcessingFee()) + "|" +
                        String.format("%.2f", salesContract.getTotalPrice()) + "|" +
                        financeOption + "|" +
                        String.format("%.2f", salesContract.getMonthlyPayment());

            } else if (contract instanceof LeaseContract) {
                LeaseContract leaseContract = (LeaseContract) contract;

                contractLine = "LEASE|" +
                        leaseContract.getDateOfContract() + "|" +
                        leaseContract.getCustomerName() + "|" +
                        leaseContract.getCustomerEmail() + "|" +
                        vehicle.getVin() + "|" +
                        vehicle.getYear() + "|" +
                        vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" +
                        vehicle.getVehicleType() + "|" +
                        vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" +
                        String.format("%.2f", vehicle.getPrice()) + "|" +
                        String.format("%.2f", leaseContract.getExpectedEndingValue()) + "|" +
                        String.format("%.2f", leaseContract.getLeaseFee()) + "|" +
                        String.format("%.2f", leaseContract.getTotalPrice()) + "|" +
                        String.format("%.2f", leaseContract.getMonthlyPayment());
            }

            contractBufferedWriter.write(contractLine);
            contractBufferedWriter.newLine();

            // Close the writers
            contractBufferedWriter.close();
            fileWriter.close();

            System.out.println("Contract saved successfully!");

            } catch (Exception e) {
                System.err.println("Error saving contract");
        }
    }
}
