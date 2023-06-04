package com.solvd.taxiservice.db.model;

public class Review {

        private String id;
        private int rating;
        private String comment;
        private Ride ride;

        public Review(){};

    public Review(String id, int rating, String comment, Ride ride) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
        this.ride = ride;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }
}
