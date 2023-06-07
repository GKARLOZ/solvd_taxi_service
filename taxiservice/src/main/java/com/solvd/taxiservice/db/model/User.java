package com.solvd.taxiservice.db.model;

import java.util.List;

public class User {

    private long id;
    private String email;
    private Profile profile;
    private DriverLicense driverLicense;
    private Vehicle vehicle;
    private List<Ride> rides;

    public User(){

        this.profile = new Profile();
        this.driverLicense = new DriverLicense();
        this.vehicle = new Vehicle();

    }


    public User(String email, Profile profile, DriverLicense driverLicense, Vehicle vehicle, List<Ride> rides) {
        this.email = email;
        this.profile = profile;
        this.driverLicense = driverLicense;
        this.vehicle = vehicle;
        this.rides = rides;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", profile=" + profile +
                ", driverLicense=" + driverLicense +
                ", vehicle=" + vehicle +
                ", rides=" + rides +
                '}';
    }
}
