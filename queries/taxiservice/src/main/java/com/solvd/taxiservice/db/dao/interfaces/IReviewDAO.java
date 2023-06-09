package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Review;

import java.util.List;

public interface IReviewDAO extends IDAO<Review> {

    public List<Review> getReviewsByRideId(long id);
}
