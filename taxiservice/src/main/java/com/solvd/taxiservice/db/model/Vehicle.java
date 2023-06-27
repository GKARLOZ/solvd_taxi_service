package com.solvd.taxiservice.db.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value="Vehicle")
public class Vehicle {

    @JsonIgnore
    private long id;

    @JsonProperty("Model")
    private String model;

    @JsonProperty("License_Plate")
    private String licensePlate;

    public Vehicle(){};

    public Vehicle( String model, String licensePlate) {

        this.model = model;
        this.licensePlate = licensePlate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
