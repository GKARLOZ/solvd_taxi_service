package com.solvd.taxiservice.db.view;

import com.solvd.taxiservice.db.model.Vehicle;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VehicleView {

    private final static Logger LOGGER = LogManager.getLogger(VehicleView.class);

    public void printVehicleDetails(Vehicle vehicle){

        LOGGER.info("Vehicle: ");
        LOGGER.info("       :model: "+ vehicle.getModel());
        LOGGER.info("       :license plate: "+ vehicle.getLicensePlate());


    }

}
