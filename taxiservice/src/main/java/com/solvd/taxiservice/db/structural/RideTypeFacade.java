package com.solvd.taxiservice.db.structural;

public class RideTypeFacade {

    private IRideType rideType;

    public RideTypeFacade(){}

    public void useComboA(){

        rideType = new StandardRideType();
        rideType.includeToRide();

    }

    public void useComboB(){

        rideType = new AddStopsRideType(new StandardRideType());
        rideType.includeToRide();
    }

    public void useComboC(){

        rideType = new TSRideType(new StandardRideType());
        rideType.includeToRide();
    }

    public void useComboD(){

        rideType = new TSRideType(new AddStopsRideType(new StandardRideType()));
        rideType.includeToRide();
    }





}
