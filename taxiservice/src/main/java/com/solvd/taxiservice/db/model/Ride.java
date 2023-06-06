package com.solvd.taxiservice.db.model;

import java.util.List;

public class Ride {

    private long id;
    private String pickUpLocations;
    private String dropOffLocation;
    private String status;
    private RideType rideType;
    private List<Review> reviews;

    public Ride(){};

    public Ride(String pickUpLocations, String dropOffLocation, String status, RideType rideType, List<Review> reviews) {
        this.pickUpLocations = pickUpLocations;
        this.dropOffLocation = dropOffLocation;
        this.status = status;
        this.rideType = rideType;
        this.reviews = reviews;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RideType getRideType() {
        return rideType;
    }

    public void setRideType(RideType rideType) {
        this.rideType = rideType;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", pickUpLocations='" + pickUpLocations + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", status='" + status + '\'' +
                ", rideType=" + rideType +
                ", reviews=" + reviews +
                '}';
    }
}
