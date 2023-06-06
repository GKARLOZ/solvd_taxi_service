package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.User;

import java.util.List;

public interface IRideDAO extends IDAO<Ride>{

    public List<Long> getRideIdByUserId(long id);
    public Ride getRideByTripId(long id);
}
