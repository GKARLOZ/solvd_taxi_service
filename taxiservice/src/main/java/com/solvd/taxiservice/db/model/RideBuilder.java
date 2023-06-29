package com.solvd.taxiservice.db.model;

import java.util.List;

public class RideBuilder {
    private String pickUpLocations;
    private String dropOffLocation;
    private String status;
    private RideType rideType;
    private List<Review> reviews;

    public RideBuilder withPickUpLocations(String pickUpLocations) {
        this.pickUpLocations = pickUpLocations;
        return this;
    }

    public RideBuilder withDropOffLocation(String dropOffLocation) {
        this.dropOffLocation = dropOffLocation;
        return this;
    }

    public RideBuilder withStatus(String status) {
        this.status = status;
        return this;
    }

    public RideBuilder withRideType(RideType rideType) {
        this.rideType = rideType;
        return this;
    }

    public RideBuilder withReviews(List<Review> reviews) {
        this.reviews = reviews;
        return this;
    }

    public Ride createRide() {
        return new Ride(pickUpLocations, dropOffLocation, status, rideType, reviews);
    }
}