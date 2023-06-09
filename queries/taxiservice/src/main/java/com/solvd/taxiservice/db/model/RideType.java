package com.solvd.taxiservice.db.model;

public class RideType {

    private long id;
    private String type;
    private double costPerMile;

    public RideType(){};

    public RideType( String type, double costPerMile) {

        this.type = type;
        this.costPerMile = costPerMile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "RideType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", costPerMile=" + costPerMile +
                '}';
    }
}
