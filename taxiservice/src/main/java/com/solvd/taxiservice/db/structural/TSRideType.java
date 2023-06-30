package com.solvd.taxiservice.db.structural;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TSRideType extends RideTypeDecorator{
    private final static Logger LOGGER = LogManager.getLogger(TSRideType.class);

    public TSRideType(IRideType iRideType) {
        super(iRideType);
    }

    @Override
    public void includeToRide() {
        super.includeToRide();
        LOGGER.info("Enable access to touch screen");
    }

    @Override
    public void addToCost() {
        super.addToCost();
        LOGGER.info("+$3");
    }

}
