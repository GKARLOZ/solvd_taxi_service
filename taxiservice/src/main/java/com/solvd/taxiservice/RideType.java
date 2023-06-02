package com.solvd.taxiservice;

public class RideType {

    private String type;
    private double costPerMile;

    public RideType(){};

    public RideType(String type, double costPerMile) {
        this.type = type;
        this.costPerMile = costPerMile;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(double costPerMile) {
        this.costPerMile = costPerMile;
    }
}
