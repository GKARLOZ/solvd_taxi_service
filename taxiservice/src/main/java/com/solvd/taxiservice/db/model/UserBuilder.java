package com.solvd.taxiservice.db.model;

import java.util.List;

public class UserBuilder {
    private long id;
    private String email;
    private Profile profile;
    private DriverLicense driverLicense;
    private Vehicle vehicle;
    private List<Ride> rides;

    public UserBuilder withId(long id) {
        this.id = id;
        return this;
    }

    public UserBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withProfile(Profile profile) {
        this.profile = profile;
        return this;
    }

    public UserBuilder withDriverLicense(DriverLicense driverLicense) {
        this.driverLicense = driverLicense;
        return this;
    }

    public UserBuilder withVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
        return this;
    }

    public UserBuilder withRides(List<Ride> rides) {
        this.rides = rides;
        return this;
    }

    public User build() {
        return new User(id, email, profile, driverLicense, vehicle, rides);
    }
}