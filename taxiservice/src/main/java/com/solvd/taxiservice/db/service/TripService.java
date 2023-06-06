package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.dao.IPromoCodeDAO;
import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.dao.ITripDAO;
import com.solvd.taxiservice.db.model.PromoCode;
import com.solvd.taxiservice.db.mysql.PromoCodeDAO;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.mysql.RideDAO;
import com.solvd.taxiservice.db.mysql.TripDAO;

public class TripService {

    ITripDAO tripDAO = new TripDAO();
    IPromoCodeDAO promoCodeDAO = new PromoCodeDAO();
    IRideDAO rideDAO = new RideDAO();
    RideService rideService = new RideService();

    public Trip getTripById(long id){
        Trip trip = tripDAO.getById(id);
        PromoCode promoCode = promoCodeDAO.getPromoCodeByTripId(id);
        Ride ride = rideService.getRideById(rideDAO.getRideByTripId(id).getId());

        trip.setPromoCode(promoCode);
        trip.setRide(ride);

        return trip;

    }



}
