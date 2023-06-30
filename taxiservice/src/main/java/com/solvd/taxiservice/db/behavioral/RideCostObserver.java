package com.solvd.taxiservice.db.behavioral;

import com.solvd.taxiservice.db.model.RideType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RideCostObserver extends Observer {

    private final static Logger LOGGER = LogManager.getLogger(RideCostObserver.class);

    public RideCostObserver(RideType rideType){

        this.ridetype = rideType;
        this.ridetype.attach(this);

    }

    @Override
    public void update() {


        LOGGER.info("Ride Type Cost per Mile with taxes:" + ridetype.getCostPerMile());

    }
}
