package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.dao.mysql.RideTypeDAO;

public interface IRideTypeDAO extends IDAO<RideTypeDAO> {

    public RideType getRideTypeByRideId(Long id);
    public RideType getRideCostByType(String type);
}
