package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IReviewDAO;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements IReviewDAO {
    @Override
    public void create(Review review) {

    }

    @Override
    public Review getById(long id) {
        return null;
    }

    @Override
    public void update(Review review) {

    }

    @Override
    public void delete(Review review) {

    }

    @Override
    public List<Review> getReviewsByRideId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
       List<Review> reviewList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Reviews\n" +
                    "where ride_id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                Review review = new Review();
                review.setId(resultSet.getLong("id"));
                review.setRating(resultSet.getInt("rating"));
                review.setComment(resultSet.getString("comment"));
                reviewList.add(review);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return reviewList ;
    }
}
