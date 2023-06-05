package com.solvd.taxiservice.db.model;

public class User {

    private String id;
    private String email;
    private Profile profile;
    private DriverLicense driverLicense;
    private Vehicle vehicle;
    public User(){};

    public User(String id, String email, Profile profile, DriverLicense driverLicense, Vehicle vehicle) {
        this.id = id;
        this.email = email;
        this.profile = profile;
        this.driverLicense = driverLicense;
        this.vehicle = vehicle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                ", driverLicense=" + driverLicense +
                ", vehicle=" + vehicle +
                '}';
    }
}
