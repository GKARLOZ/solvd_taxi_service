package com.solvd.taxiservice.db.controller;

import com.solvd.taxiservice.db.model.Vehicle;
import com.solvd.taxiservice.db.view.VehicleView;

public class VehicleController {
    private Vehicle vehicle;
    private VehicleView vehicleView;

    public VehicleController(Vehicle vehicle, VehicleView vehicleView){

        this.vehicle = vehicle;
        this.vehicleView = vehicleView;

    }

    public String getModel() {
        return vehicle.getModel();
    }

    public void setModel(String model) {
        vehicle.setModel(model);
    }

    public String getLicensePlate() {
        return vehicle.getLicensePlate();
    }

    public void setLicensePlate(String licensePlate) {
        vehicle.setLicensePlate(licensePlate);
    }

    public void updateView(){
        vehicleView.printVehicleDetails(vehicle);
    }
}
