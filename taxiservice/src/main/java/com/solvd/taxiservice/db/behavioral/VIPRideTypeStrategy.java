package com.solvd.taxiservice.db.behavioral;

public class VIPRideTypeStrategy implements ICalculateFareStrategy{
    @Override
    public double calculateFare(double distance) {
        return distance * 3.65;
    }


}
