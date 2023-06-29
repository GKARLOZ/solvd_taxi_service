package com.solvd.taxiservice.db.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AddStopsRideType extends RideTypeDecorator{

    private final static Logger LOGGER = LogManager.getLogger(AddStopsRideType.class);

    public AddStopsRideType(IRideType iRideType) {
        super(iRideType);
    }

    @Override
    public void includeToRide() {
        super.includeToRide();
        LOGGER.info(" Enable unlimited stops");
    }

    @Override
    public void addToCost() {
        super.addToCost();
        LOGGER.info("+$1 extra per Mile");
    }
}
