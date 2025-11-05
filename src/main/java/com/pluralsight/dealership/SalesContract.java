package com.pluralsight.dealership;

public class SalesContract extends Contract{
    private double salesTaxRateAsPercentage;
    private double salesTaxAmount;
    private double recordingFee;
    private double processingFee;
    private boolean isFinanced;
    private boolean isUnder10000;

    public SalesContract(String dateOfContract, String customerName, String customerEmail, Vehicle vehicleSold, double salesTaxRateAsPercentage, boolean isFinanced) {
        super(dateOfContract, customerName, customerEmail, vehicleSold);
        this.salesTaxRateAsPercentage = salesTaxRateAsPercentage;
        this.salesTaxAmount = (salesTaxRateAsPercentage * 0.01) * vehicleSold.getPrice();
        this.recordingFee = 100;
        if (vehicleSold.getPrice() < 10000) {
            this.isUnder10000 = true;
        }
        if (this.isUnder10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.isFinanced = isFinanced;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getSalesTaxRateAsPercentage() {
        return salesTaxRateAsPercentage;
    }

    public void setSalesTaxRateAsPercentage(double salesTaxRate) {
        this.salesTaxRateAsPercentage = salesTaxRate;
    }

    public double getRecordingFee() {
        return recordingFee;
    }

    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public double getProcessingFee() {
        return processingFee;
    }

    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public boolean isFinanced() {
        return isFinanced;
    }

    public void setFinanced(boolean financed) {
        isFinanced = financed;
    }

    public boolean isUnder10000() {
        return isUnder10000;
    }

    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee);
    }

    @Override
    public double getMonthlyPayment() {
        if (!isFinanced) {
            return 0;
        }

        double monthlyInterestRate;
        int numberOfMonths;

        if (isUnder10000) {
            monthlyInterestRate = 0.0525 / 12;
            numberOfMonths = 24;
        } else {
            monthlyInterestRate = 0.0425 / 12;
            numberOfMonths = 48;
        }

        return getTotalPrice() * (monthlyInterestRate * Math.pow(1 + monthlyInterestRate, numberOfMonths)) / (Math.pow(1 + monthlyInterestRate, numberOfMonths) - 1);
    }
}
