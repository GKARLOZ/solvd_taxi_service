package com.solvd.taxiservice.db.decorator;

import com.solvd.taxiservice.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StandardRideType implements IRideType {

    private final static Logger LOGGER = LogManager.getLogger(StandardRideType.class);


    @Override
    public void includeToRide() {
        LOGGER.info("Enable radio and AC");
    }

    @Override
    public void addToCost() {
        LOGGER.info(" +$0");
    }
}
