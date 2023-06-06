package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.mysql.RideTypeDAO;

public interface IRideTypeDAO extends IDAO<RideTypeDAO>{

    public RideType getRideTypeByRideId(Long id);
    public RideType getRideCostByType(String type);
}
