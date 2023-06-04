package com.solvd.taxiservice.db.model;

public class Trip {

    private String id;
    //SartTime and endtime need to be changed to localdatetime
    private String startTime;
    private String endTime;
    private double distance;
    private Ride ride;
    private PromoCode promoCode;

    public Trip(){};

    public Trip(String id, String startTime, String endTime, double distance, Ride ride, PromoCode promoCode) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.ride = ride;
        this.promoCode = promoCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public PromoCode getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(PromoCode promoCode) {
        this.promoCode = promoCode;
    }
}
