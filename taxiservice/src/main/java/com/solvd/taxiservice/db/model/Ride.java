package com.solvd.taxiservice.db.model;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.List;

@JsonRootName(value="Ride")
@JsonIncludeProperties({"PickUp Location","DropOff Location"})
public class Ride {

    private long id;
    @JsonProperty("PickUp Location")
    private String pickUpLocations;

    @JsonProperty("DropOff Location")
    private String dropOffLocation;
    private String status;
    private RideType rideType;
    private List<Review> reviews;

    public Ride(){
        this.rideType = new RideType();
    };

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
