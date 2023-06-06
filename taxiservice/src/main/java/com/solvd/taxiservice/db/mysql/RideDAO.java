package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.model.PromoCode;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RideDAO implements IRideDAO {
    @Override
    public void create(Ride ride) {

    }

    @Override
    public Ride getById(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        Ride ride = new Ride();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Rides WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                ride.setId(resultSet.getLong("id"));
                ride.setPickUpLocations(resultSet.getString("pickup_location"));
                ride.setDropOffLocation(resultSet.getString("dropoff_location"));
                ride.setStatus(resultSet.getString("ride_status"));
            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return ride;
    }

    @Override
    public void update(Ride ride) {

    }

    @Override
    public void delete(Ride ride) {

    }

    @Override
    public List<Long> getRideIdByUserId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        List<Long> rideList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Rides\n" +
                    "where user_id = ?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                rideList.add(resultSet.getLong("id"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return rideList ;
    }

    @Override
    public Ride getRideByTripId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
       Ride ride = new Ride();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Rides\n" +
                    "where id = (select ride_id  from Trips where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                ride.setId(resultSet.getLong("id"));
                ride.setPickUpLocations(resultSet.getString("pickup_location"));
                ride.setDropOffLocation(resultSet.getString("dropoff_location"));
                ride.setStatus(resultSet.getString("ride_status"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return ride;
    }
}
