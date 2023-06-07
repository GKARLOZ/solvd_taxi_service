package com.solvd.taxiservice.db.service.implement;

import com.solvd.taxiservice.db.dao.interfaces.IReviewDAO;
import com.solvd.taxiservice.db.dao.interfaces.IRideDAO;
import com.solvd.taxiservice.db.dao.interfaces.IRideTypeDAO;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.dao.mysql.ReviewDAO;
import com.solvd.taxiservice.db.dao.mysql.RideDAO;
import com.solvd.taxiservice.db.dao.mysql.RideTypeDAO;

import java.util.ArrayList;
import java.util.List;

public class RideService {

    private IRideDAO rideDAO = new RideDAO();
    private IRideTypeDAO rtypeDAO = new RideTypeDAO();
    private IReviewDAO reviewDAO = new ReviewDAO();
    public Ride getRideById(long id){

        Ride ride = rideDAO.getById(id);
        RideType rt = rtypeDAO.getRideTypeByRideId(id);
        List<Review> reviewList = reviewDAO.getReviewsByRideId(id);

        ride.setRideType(rt);
        ride.setReviews(reviewList);

        return ride;
    }

    public List<Ride> getRideByUserId(long userId){

        List<Ride> rides = new ArrayList<>();
        List<Long> ids = rideDAO.getRideIdByUserId(userId);

        for (Long RideId:ids) {

            rides.add(getRideById(RideId));
        }
        return rides;

    }

    public Ride getRideByTripId(long id){

        Ride ride = rideDAO.getRideByTripId(id);
        Long rideId = ride.getId();
        RideType rt = rtypeDAO.getRideTypeByRideId(rideId);
        List<Review> reviewList = reviewDAO.getReviewsByRideId(rideId);

        ride.setRideType(rt);
        ride.setReviews(reviewList);

        return ride;
    }


}