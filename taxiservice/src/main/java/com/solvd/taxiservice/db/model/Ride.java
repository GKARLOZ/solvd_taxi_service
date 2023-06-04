package com.solvd.taxiservice.db.model;

public class Ride {

    private String id;
    private String pickUpLocations;
    private String dropOffLocation;
    private RideType rideType;
    private User user;

    public Ride(){};

    public Ride(String id, String pickUpLocations, String dropOffLocation, RideType rideType, User user) {
        this.id = id;
        this.pickUpLocations = pickUpLocations;
        this.dropOffLocation = dropOffLocation;
        this.rideType = rideType;
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPickUpLocations() {
        return pickUpLocations;
    }

    public void setPickUpLocations(String pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
    }

    public String getDropOffLocation() {
        return dropOffLocation;
    }

    public void setDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
