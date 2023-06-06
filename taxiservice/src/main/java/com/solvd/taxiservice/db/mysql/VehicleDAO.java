package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.Vehicle;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class VehicleDAO  implements IVehicleDAO {
    private final static Logger LOGGER = LogManager.getLogger(Vehicle.class);

    @Override
    public void create(Vehicle vehicle) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO vehicles (license_plate,vehicle_model) VALUES (?,?)");

            preparedStatement.setString(1, vehicle.getLicensePlate());
            preparedStatement.setString(2,vehicle.getModel());



            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Vehicle created successfully.");
            } else {
                LOGGER.info("Failed to create Vehicle.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }


    }

    @Override
    public Vehicle getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Vehicles WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                vehicle.setId(resultSet.getLong("id"));
               vehicle.setLicensePlate(resultSet.getString("license_plate"));
               vehicle.setModel(resultSet.getString("vehicle_model"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return vehicle ;
    }

    @Override
    public void update(Vehicle vehicle) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE Vehicles SET license_plate = ?,  vehicle_model= ? WHERE id = ?");

            preparedStatement.setString(1,vehicle.getLicensePlate());
            preparedStatement.setString(2,vehicle.getModel());
            preparedStatement.setLong(3,vehicle.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Vehicle updated successfully.");
            } else {
                LOGGER.info("No Vehicle found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    @Override
    public void delete(Vehicle vehicle) {


        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM Vehicles WHERE id = ?");

            preparedStatement.setLong(1,vehicle.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Vehicle deleted successfully.");
            } else {
                LOGGER.info("Vehicle found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }


    }

    @Override
    public Vehicle getVehicleByUserId(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from vehicles\n" +
                    "where id = (select vehicle_id  from users where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                vehicle.setId(resultSet.getLong("id"));
                vehicle.setLicensePlate(resultSet.getString("license_plate"));
                vehicle.setModel(resultSet.getString("vehicle_model"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return vehicle;

    }

    @Override
    public Vehicle getVehicleByLicensePlate(String lp) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Vehicles WHERE license_plate=?");
            preparedStatement.setString(1,lp);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                vehicle.setId(resultSet.getLong("id"));
                vehicle.setLicensePlate(resultSet.getString("license_plate"));
                vehicle.setModel(resultSet.getString("vehicle_model"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return vehicle ;
    }

    @Override
    public Vehicle createVehicle(Vehicle vehicle) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO vehicles (license_plate,vehicle_model) VALUES (?,?)");

            preparedStatement.setString(1, vehicle.getLicensePlate());
            preparedStatement.setString(2,vehicle.getModel());


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Vehicle created successfully.");
            } else {
                LOGGER.info("Failed to create Vehicle.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            long generatedId = -1;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);

            }
            vehicle.setId(generatedId);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return vehicle;
    }


}
