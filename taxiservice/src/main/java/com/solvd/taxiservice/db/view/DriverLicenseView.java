package com.solvd.taxiservice.db.view;

import com.solvd.taxiservice.db.model.DriverLicense;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DriverLicenseView {

    private final static Logger LOGGER = LogManager.getLogger(DriverLicenseView.class);

    public void printDLDetails(DriverLicense dl){

        LOGGER.info("Driver License: ");
        LOGGER.info("              :license number: "+ dl.getLicenseNumber());


    }
}
