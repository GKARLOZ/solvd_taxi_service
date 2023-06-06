package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Trip;

public interface ITripDAO extends IDAO<Trip>{

    public Trip getTripByRideId(long id);
    public Trip getTripByInvoiceId(long id);
}
