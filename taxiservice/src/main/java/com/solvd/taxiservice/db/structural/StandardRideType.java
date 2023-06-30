package com.solvd.taxiservice.db.structural;

import com.solvd.taxiservice.db.behavioral.ICalculateFareStrategy;
import com.solvd.taxiservice.db.model.RideType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class StandardRideType extends RideType implements IRideType {

    private final static Logger LOGGER = LogManager.getLogger(StandardRideType.class);



    @Override
    public void includeToRide() {

        LOGGER.info("Enable radio and AC");
    }

    @Override
    public void addToCost() {

        LOGGER.info(" +$0");
    }

    public void setRideTypeStrategy(ICalculateFareStrategy iCal, double distance){

        iCal.calculateFare(distance);

    }


}
