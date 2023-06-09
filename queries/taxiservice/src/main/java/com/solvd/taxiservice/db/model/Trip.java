package com.solvd.taxiservice.db.model;

import java.time.LocalDateTime;

public class Trip {

    private long id;
    //SartTime and endtime need to be changed to localdatetime
    private LocalDateTime startTime;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", distance=" + distance +
                ", ride=" + ride +
                ", promoCode=" + promoCode +
                '}';
    }
}
