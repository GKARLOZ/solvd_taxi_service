package com.solvd.taxiservice;

import java.time.LocalDateTime;

public class Trip {

    private LocalDateTime startTime = LocalDateTime.now();
    private LocalDateTime endTime;
    private double distance;
    private Ride ride;
    private PromoCode promoCode;

    public Trip(){};

    public Trip(LocalDateTime startTime, LocalDateTime endTime, double distance, Ride ride, PromoCode promoCode) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.distance = distance;
        this.ride = ride;
        this.promoCode = promoCode;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
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
