package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.ITripDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TripDAO implements ITripDAO {

    private final static Logger LOGGER = LogManager.getLogger(Trip.class);
    @Override
    public void create(Trip trip) {

    }

    @Override
    public Trip getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Trip trip = new Trip();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM trips WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                trip.setId(resultSet.getLong("id"));
                trip.setEndTime(resultSet.getTimestamp("start_date_time").toLocalDateTime());
                trip.setStartTime(resultSet.getTimestamp("end_date_time").toLocalDateTime());
                trip.setDistance(resultSet.getDouble("distance"));

            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return trip;

    }

    @Override
    public void update(Trip trip) {

    }

    @Override
    public void delete(Trip trip) {

    }

    @Override
    public Trip getTripByRideId(long id) {
        return null;
    }

    @Override
    public Trip getTripByInvoiceId(long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
       Trip  trip = new Trip();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Trips\n" +
                    "where id = (select trip_id  from Invoices where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                trip.setId(resultSet.getLong("id"));
                trip.setEndTime(resultSet.getTimestamp("start_date_time").toLocalDateTime());
                trip.setStartTime(resultSet.getTimestamp("end_date_time").toLocalDateTime());
                trip.setDistance(resultSet.getDouble("distance"));


            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return trip;
    }
}
