package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.IReviewDAO;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements IReviewDAO {
    private final static Logger LOGGER = LogManager.getLogger(ReviewDAO.class);


    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Review table.");
            } else {
                LOGGER.info("No rows affected in Review table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Review queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Review review = new Review();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            try(ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {

                    review.setId(resultSet.getLong("id"));
                    review.setRating(resultSet.getInt("rating"));
                    review.setComment(resultSet.getString("comment"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return review;

    }


    @Override
    public void create(Review review) {
        //executeQuery("INSERT INTO Reviews (rating,comment,ride_id) VALUES (?,?,?)",review.getRating(),review.getComment());

    }

    @Override
    public Review getById(long id){
        Long rId = id;
        return queryGet("SELECT * FROM Reviews WHERE ID=?",rId);
    }

    @Override
    public void update(Review review) {
        executeQuery("UPDATE Reviews SET rating = ?,  comment= ? WHERE id = ?",review.getRating(),review.getComment(),review.getId() );

    }

    @Override
    public void delete(Review review) {
        executeQuery("DELETE FROM Reviews WHERE id = ?",review.getId());

    }

    @Override
    public List<Review> getReviewsByRideId(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
       List<Review> reviewList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from Reviews\n" +
                "where ride_id = ?");) {

            preparedStatement.setLong(1,id);

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Review review = new Review();
                    review.setId(resultSet.getLong("id"));
                    review.setRating(resultSet.getInt("rating"));
                    review.setComment(resultSet.getString("comment"));
                    reviewList.add(review);
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return reviewList ;
    }
}
