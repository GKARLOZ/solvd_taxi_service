package com.solvd.taxiservice.db.view;

import com.solvd.taxiservice.db.model.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class UserView {

    private final static Logger LOGGER = LogManager.getLogger(UserView.class);

    private DriverLicenseView dlv = new DriverLicenseView();
    private ProfileView pv = new ProfileView();
    private VehicleView vv = new VehicleView();



    public void printUserDetails(User user){

        LOGGER.info("User ");
        LOGGER.info("       :email: "+user.getEmail());
        pv.printProfileDetails(user.getProfile());
        dlv.printDLDetails(user.getDriverLicense());
        vv.printVehicleDetails(user.getVehicle());


    }
}
