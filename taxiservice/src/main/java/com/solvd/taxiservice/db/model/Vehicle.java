package com.solvd.taxiservice.db.model;

public class Vehicle {

    private String id;
    private String model;
    private String licensePlate;

    public Vehicle(){};

    public Vehicle(String id, String model, String licensePlate) {
        this.id = id;
        this.model = model;
        this.licensePlate = licensePlate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", model='" + model + '\'' +
                ", licensePlate='" + licensePlate + '\'' +
                '}';
    }
}
