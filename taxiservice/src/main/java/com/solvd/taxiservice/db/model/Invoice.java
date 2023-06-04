package com.solvd.taxiservice.db.model;

public class Invoice {

    private String id;
    private double taxAmount;
    private double totalAmount;
    private Trip trip;
    public Invoice(){};

    public Invoice(String id, double taxAmount, double totalAmount, Trip trip) {
        this.id = id;
        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.trip = trip;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
