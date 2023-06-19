package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Review;

import java.util.List;

public interface IReviewDAO extends IDAO<Review> {

    public List<Review> getReviewsByRideId(long id);
}
