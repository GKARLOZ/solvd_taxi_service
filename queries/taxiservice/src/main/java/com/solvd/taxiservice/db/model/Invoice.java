package com.solvd.taxiservice.db.model;

public class Invoice {

    private long id;
    private double taxAmount;
    private double totalAmount;
    private Trip trip;
    public Invoice(){
        this.trip = new Trip();
    };

    public Invoice( double taxAmount, double totalAmount, Trip trip) {

        this.taxAmount = taxAmount;
        this.totalAmount = totalAmount;
        this.trip = trip;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Invoice{" +
                "id=" + id +
                ", taxAmount=" + taxAmount +
                ", totalAmount=" + totalAmount +
                ", trip=" + trip +
                '}';
    }
}
