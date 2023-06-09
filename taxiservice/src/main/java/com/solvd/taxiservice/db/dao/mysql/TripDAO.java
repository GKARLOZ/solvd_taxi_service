package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.ITripDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Review;
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

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Trip table.");
            } else {
                LOGGER.info("No rows affected in Trip table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Trip queryGet(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        Trip trip = new Trip();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Trips WHERE ID=?");

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                trip.setId(resultSet.getLong("id"));
                trip.setEndTime(resultSet.getTimestamp("start_date_time").toLocalDateTime());
                trip.setStartTime(resultSet.getTimestamp("end_date_time").toLocalDateTime());
                trip.setDistance(resultSet.getDouble("distance"));
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return trip;

    }
    @Override
    public void create(Trip trip) {
        executeQuery("INSERT INTO Trips (start_date_time, end_date_time, distance) VALUES (?,?,?)", trip.getStartTime(),trip.getEndTime(),trip.getDistance());

    }

    @Override
    public Trip getById(long id) {

        Long rId = id;
        return queryGet("SELECT * FROM Trips WHERE ID=?",rId);

    }

    @Override
    public void update(Trip trip) {
        executeQuery("UPDATE Trips SET start_date_time = ?,  end_date_time= ?, distance=?, WHERE id = ?",trip.getStartTime(),trip.getEndTime(),trip.getDistance(),trip.getId());

    }

    @Override
    public void delete(Trip trip) {
        executeQuery("DELETE FROM Trips WHERE id = ?",trip.getId());
    }

    @Override
    public Trip getTripByRideId(long id) {
        Long rId = id;
        return queryGet("select * from Trips where id = (select trip_id  from Rides where id = ?);",rId);
    }

    @Override
    public Trip getTripByInvoiceId(long id) {
        Long rId = id;
        return queryGet("select * from Trips where id = (select trip_id  from Invoices where id = ?);",rId);

    }
}
