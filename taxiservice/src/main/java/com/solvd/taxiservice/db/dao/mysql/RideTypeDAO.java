package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IRideTypeDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.Review;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideTypeDAO implements IRideTypeDAO {

    private final static Logger LOGGER = LogManager.getLogger(Review.class);

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
                LOGGER.info(rowsAffected + " row affected in Ride Types table.");
            } else {
                LOGGER.info("No rows affected in Ride Types table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private RideType queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
       RideType rt = new RideType();
        try {
            preparedStatement = connection.prepareStatement(query);

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {

                rt.setId(resultSet.getLong("id"));
                rt.setType(resultSet.getString("type"));
                rt.setCostPerMile(resultSet.getDouble("cost_per_mile"));
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return rt;

    }

    @Override
    public void create(RideType rideType) {
        executeQuery("INSERT INTO Ride_Types (type,cost_per_mile) VALUES (?,?)",rideType.getType(),rideType.getCostPerMile());

    }

    @Override
    public RideType getById(long id) {
        Long rId = id;
        return queryGet("SELECT * FROM Ride_Types WHERE ID=?",rId);
    }

    @Override
    public void update(RideType rideType) {
        executeQuery("UPDATE Ride_Types SET type = ?,  cost_per_mile= ? WHERE id = ?",rideType.getType(),rideType.getCostPerMile(),rideType.getId() );

    }

    @Override
    public void delete(RideType rideType) {
        executeQuery("DELETE FROM Ride_Types WHERE id = ?",rideType.getId());

    }

    @Override
    public RideType getRideTypeByRideId(Long id) {
        Long rId = id;
        return queryGet("select * from Ride_Types where id = (select ride_type_id from Rides where id = ?);",rId);

    }

}
