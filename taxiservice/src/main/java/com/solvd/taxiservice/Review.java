package com.solvd.taxiservice;

public class Review {

        private int rating;
        private String comment;
        private Ride ride;

        public Review(){};

    public Review(int rating, String comment, Ride ride) {
        this.rating = rating;
        this.comment = comment;
        this.ride = ride;
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
