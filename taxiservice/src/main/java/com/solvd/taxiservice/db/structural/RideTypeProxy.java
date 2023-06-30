package com.solvd.taxiservice.db.structural;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RideTypeProxy implements IRideType{

    private final static Logger LOGGER = LogManager.getLogger(RideTypeProxy.class);

    private StandardRideType sRideType;

    public RideTypeProxy(){}

    @Override
    public void includeToRide() {
        if (sRideType == null){
            sRideType = new StandardRideType();
        }
        LOGGER.info(" Checking for restrictions before executing real IrideType....");
        sRideType.includeToRide();
    }

    @Override
    public void addToCost() {

        if (sRideType == null){
            sRideType = new StandardRideType();
        }
        sRideType.addToCost();
    }

}
