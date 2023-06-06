package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IRideTypeDAO;
import com.solvd.taxiservice.db.model.RideType;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RideTypeDAO implements IRideTypeDAO {


    @Override
    public void create(RideTypeDAO rideTypeDAO) {

    }

    @Override
    public RideTypeDAO getById(long id) {
        return null;
    }

    @Override
    public void update(RideTypeDAO rideTypeDAO) {

    }

    @Override
    public void delete(RideTypeDAO rideTypeDAO) {

    }

    @Override
    public RideType getRideTypeByRideId(Long id) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        RideType rt  = new RideType();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Ride_Types\n" +
                    "where id = (select ride_type_id from Rides where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                rt.setId(resultSet.getLong("id"));
                rt.setType(resultSet.getString("type"));
                rt.setCostPerMile(resultSet.getDouble("cost_per_mile"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return rt ;
    }

    @Override
    public RideType getRideCostByType(String type) {
        return null;
    }
}
