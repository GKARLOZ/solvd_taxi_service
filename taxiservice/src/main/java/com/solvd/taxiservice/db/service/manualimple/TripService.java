package com.solvd.taxiservice.db.service.manualimple;

import com.solvd.taxiservice.db.dao.IPromoCodeDAO;
import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.dao.ITripDAO;
import com.solvd.taxiservice.db.model.PromoCode;
import com.solvd.taxiservice.db.dao.mysql.PromoCodeDAO;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.dao.mysql.RideDAO;
import com.solvd.taxiservice.db.dao.mysql.TripDAO;

public class TripService {

    private ITripDAO tripDAO = new TripDAO();
    private IPromoCodeDAO promoCodeDAO = new PromoCodeDAO();
    private IRideDAO rideDAO = new RideDAO();
    private RideService rideService = new RideService();

    public Trip getTripById(long id){
        Trip trip = tripDAO.getById(id);
        PromoCode promoCode = promoCodeDAO.getPromoCodeByTripId(id);
        Ride ride = rideService.getById(rideDAO.getRideByTripId(id).getId());

        trip.setPromoCode(promoCode);
        trip.setRide(ride);

        return trip;

    }



}
