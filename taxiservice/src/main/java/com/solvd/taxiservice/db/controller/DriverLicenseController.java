package com.solvd.taxiservice.db.controller;

import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.view.DriverLicenseView;

public class DriverLicenseController {

    private DriverLicense driverLicense;
    private DriverLicenseView driverLicenseView;

    public DriverLicenseController(DriverLicense dl , DriverLicenseView dlv){

        this.driverLicense = dl;
        this.driverLicenseView = dlv;

    }
    public String getLicenseNumber() {
        return driverLicense.getLicenseNumber();
    }

    public void setLicenseNumber(String licenseNumber) {
        driverLicense.setLicenseNumber(licenseNumber);
    }

    public void updateView(){
        driverLicenseView.printDLDetails(driverLicense);
    }


}
