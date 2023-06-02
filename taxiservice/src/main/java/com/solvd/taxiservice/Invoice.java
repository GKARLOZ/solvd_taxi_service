package com.solvd.taxiservice;

public class Invoice {

    private double taxAmount;
    private double totalAmount;
    private Trip trip;
    public Invoice(){};

    public Invoice(double taxAmount, double totalAmount, Trip trip) {
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.trip = trip;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Trip getTrip() {
        return trip;
    }

    public void setTrip(Trip trip) {
        this.trip = trip;
    }
}
