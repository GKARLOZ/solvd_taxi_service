package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Ride;

import java.util.List;

public interface IRideDAO extends IDAO<Ride> {

    public List<Long> getRideIdByUserId(long id);
    public Ride getRideByTripId(long id);
}
