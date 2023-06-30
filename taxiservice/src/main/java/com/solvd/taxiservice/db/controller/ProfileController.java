package com.solvd.taxiservice.db.controller;

import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.Vehicle;
import com.solvd.taxiservice.db.view.ProfileView;

public class ProfileController {

    private Profile profile;
    private ProfileView profileView;

    public ProfileController(Profile profile, ProfileView profileView){

        this.profile = profile;
        this.profileView = profileView;
    }

    public String getName() {
        return profile.getName();
    }

    public void setName(String name) {
        profile.setName(name);
    }

    public String getPhoneNumber() {
        return profile.getPhoneNumber();
    }

    public void setPhoneNumber(String phoneNumber) {
        profile.setPhoneNumber(phoneNumber);
    }

    public void updateView(){
        profileView.printProfileDetails(profile);
    }


}
