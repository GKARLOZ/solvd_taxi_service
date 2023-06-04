package com.solvd.taxiservice.db.model;

public class RideType {

    private String id;
    private String type;
    private double costPerMile;

    public RideType(){};

    public RideType(String id, String type, double costPerMile) {
        this.id = id;
        this.type = type;
        this.costPerMile = costPerMile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
