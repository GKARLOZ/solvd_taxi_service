package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.RideType;

public interface IRideTypeDAO extends IDAO<RideType> {

    public RideType getRideTypeByRideId(Long id);

}
