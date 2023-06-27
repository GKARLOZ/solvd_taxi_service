package com.solvd.taxiservice.db.dao.mybatis;

import com.solvd.taxiservice.db.dao.ITripDAO;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.service.IService;

public class TripDAO implements ITripDAO {

    @Override
    public void create(Trip trip) {

    }

    @Override
    public Trip getById(long id) {
        return null;
    }

    @Override
    public void update(Trip trip) {

    }

    @Override
    public void delete(Trip trip) {

    }

    @Override
    public Trip getTripByRideId(long id) {
        return null;
    }

    @Override
    public Trip getTripByInvoiceId(long id) {
        return null;
    }
}
