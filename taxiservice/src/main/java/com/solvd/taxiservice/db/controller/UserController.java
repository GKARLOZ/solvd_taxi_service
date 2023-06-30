package com.solvd.taxiservice.db.controller;

import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.imple.UserService;
import com.solvd.taxiservice.db.view.UserView;

import java.util.List;

public class UserController {

    private User user;
    private UserView userView;

    public UserController(User user, UserView userView){
        this.user = user;
        this.userView = userView;
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        user.setEmail(email);
    }

    public Profile getProfile() {
        return user.getProfile();
    }

    public void setProfile(Profile profile) {
        user.setProfile(profile);
    }

    public DriverLicense getDriverLicense() {
        return user.getDriverLicense();
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        user.setDriverLicense(driverLicense);
    }

    public Vehicle getVehicle() {
        return user.getVehicle();
    }

    public void setVehicle(Vehicle vehicle) {
        user.setVehicle(vehicle);
    }

    public void updateView(){
        userView.printUserDetails(user);
    }


}
