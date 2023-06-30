package com.solvd.taxiservice.db.structural;

public class RideTypeDecorator implements IRideType{

    protected IRideType iRideType;

    public RideTypeDecorator(IRideType iRideType){
        this.iRideType = iRideType;
    }

    @Override
    public void includeToRide() {
        this.iRideType.includeToRide();
    }

    @Override
    public void addToCost() {
        this.iRideType.includeToRide();
    }
}
