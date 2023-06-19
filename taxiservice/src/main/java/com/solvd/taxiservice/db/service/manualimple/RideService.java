package com.solvd.taxiservice.db.service.manualimple;

import com.solvd.taxiservice.db.dao.IReviewDAO;
import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.dao.IRideTypeDAO;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.dao.mysql.ReviewDAO;
import com.solvd.taxiservice.db.dao.mysql.RideDAO;
import com.solvd.taxiservice.db.dao.mysql.RideTypeDAO;
import com.solvd.taxiservice.db.service.IRideService;

import java.util.ArrayList;
import java.util.List;

public class RideService implements IRideService {

    private IRideDAO rideDAO = new RideDAO();
    private IRideTypeDAO rtypeDAO = new RideTypeDAO();
    private IReviewDAO reviewDAO = new ReviewDAO();

    @Override
    public Ride getById(long id){

        Ride ride = rideDAO.getById(id);
        RideType rt = rtypeDAO.getRideTypeByRideId(id);
        List<Review> reviewList = reviewDAO.getReviewsByRideId(id);

        ride.setRideType(rt);
        ride.setReviews(reviewList);

        return ride;
    }
    @Override
    public List<Ride> getRideByUserId(long userId){

        List<Ride> rides = new ArrayList<>();
        List<Long> ids = rideDAO.getRideIdByUserId(userId);

        for (Long RideId:ids) {

            rides.add(getById(RideId));
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


    @Override
    public void create(Ride ride) {

        //rideDAO.create(ride);
    }

    @Override
    public void update(Ride ride) {

        //rideDAO.update(ride);

    }

    @Override
    public void delete(Ride ride) {
//        List<Review>  reviews = reviewDAO.getReviewsByRideId(ride.getId());
//        for (Review r: reviews) {
//            reviewDAO.delete(r);
//
//        }
//            rideDAO.delete(ride);
//
  }
}
