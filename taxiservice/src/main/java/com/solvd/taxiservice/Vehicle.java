package com.solvd.taxiservice;

public class Vehicle {

    private String model;
    private String licensePlate;

    public Vehicle(){};

    public Vehicle(String model, String licensePlate) {
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }
}
