package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.dao.IReviewDAO;
import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.dao.IRideTypeDAO;
import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.mysql.ReviewDAO;
import com.solvd.taxiservice.db.mysql.RideDAO;
import com.solvd.taxiservice.db.mysql.RideTypeDAO;
import com.solvd.taxiservice.db.mysql.UserDAO;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RideService {

    IRideDAO rideDAO = new RideDAO();
    IRideTypeDAO rtypeDAO = new RideTypeDAO();
    IReviewDAO reviewDAO = new ReviewDAO();
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
