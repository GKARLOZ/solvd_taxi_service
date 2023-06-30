package com.solvd.taxiservice.db.behavioral;

public class StandardRideTypeStrategy implements ICalculateFareStrategy{


    @Override
    public double calculateFare(double distance) {
        return distance * 1.0;
    }
}
