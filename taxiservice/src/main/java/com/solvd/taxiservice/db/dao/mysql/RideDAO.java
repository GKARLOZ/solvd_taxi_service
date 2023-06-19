package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.IRideDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Ride;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RideDAO implements IRideDAO {

    private final static Logger LOGGER = LogManager.getLogger(DriverLicense.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Rides table.");
            } else {
                LOGGER.info("No rows affected in Rides table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Ride queryGet(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Ride ride = new Ride();

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    ride.setId(resultSet.getLong("id"));
                    ride.setPickUpLocations(resultSet.getString("pickup_location"));
                    ride.setDropOffLocation(resultSet.getString("dropoff_location"));
                    ride.setStatus(resultSet.getString("ride_status"));

                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return ride;

    }


    @Override
    public void create(Ride ride) {
        //executeQuery("INSERT INTO Rides (pickup_location,dropoff_location,ride_status,user_id,ride_type_id) VALUES (?,?,?,?,?)",ride.getPickUpLocations(),ride.getDropOffLocation(),ride.getStatus(),0,ride.getRideType().getId());

    }

    @Override
    public Ride getById(long id) {
        Long rId = id;
        return queryGet("SELECT * FROM Rides WHERE ID=?",rId);

    }

    @Override
    public void update(Ride ride) {
        executeQuery("UPDATE Rides SET pickup_location = ?,dropoff_location=?,ride_status=? WHERE id = ?",ride.getPickUpLocations(),ride.getDropOffLocation(),ride.getStatus(),ride.getId());

    }

    @Override
    public void delete(Ride ride) {
        executeQuery("DELETE FROM Rides WHERE id = ?",ride.getId());
    }

    @Override
    public Ride getRideByTripId(long id) {
        Long rId = id;
        return queryGet("select * from Rides where id = (select ride_id  from Trips where id = ?);",rId);

    }

    @Override
    public List<Long> getRideIdByUserId(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        List<Long> rideList = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement("select * from Rides\n" +
                "where user_id = ?");) {

            preparedStatement.setLong(1,id);
            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    rideList.add(resultSet.getLong("id"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return rideList ;
    }


}
