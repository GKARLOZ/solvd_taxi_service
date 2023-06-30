package com.solvd.taxiservice.db.view;

import com.solvd.taxiservice.db.model.Profile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ProfileView {

    private final static Logger LOGGER = LogManager.getLogger(ProfileView.class);

    public void printProfileDetails(Profile profile){

        LOGGER.info("Profile: ");
        LOGGER.info("       :name: "+ profile.getName());
        LOGGER.info("       :phone num: "+ profile.getPhoneNumber());

    }
}
