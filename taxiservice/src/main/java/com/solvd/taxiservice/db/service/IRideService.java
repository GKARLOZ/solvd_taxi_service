package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.model.Ride;

import java.util.List;

public interface IRideService extends IService<Ride>{

    public List<Ride> getRideByUserId(long userId);
    public Ride getRideByTripId(long id);

}
