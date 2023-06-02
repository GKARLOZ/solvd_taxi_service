package com.solvd.taxiservice;

public class User {

    private String email;
    private Profile profile;
    private DriverLicense driverLicense;
    private Vehicle vehicle;
    public User(){};

    public User(String email, Profile profile, DriverLicense driverLicense, Vehicle vehicle) {
        this.email = email;
        this.profile = profile;
        this.driverLicense = driverLicense;
        this.vehicle = vehicle;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public DriverLicense getDriverLicense() {
        return driverLicense;
    }

    public void setDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
