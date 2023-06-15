package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IVehicleDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Vehicle;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class VehicleDAO  implements IVehicleDAO {
    private final static Logger LOGGER = LogManager.getLogger(Vehicle.class);

    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Vehicle table.");
            } else {
                LOGGER.info("No rows affected in Vehicle table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private Vehicle queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    vehicle.setId(resultSet.getLong("id"));
                    vehicle.setLicensePlate(resultSet.getString("license_plate"));
                    vehicle.setModel(resultSet.getString("vehicle_model"));
                }
            }

            } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return vehicle;

    }


    @Override
    public void create(Vehicle vehicle) {

        executeQuery("INSERT INTO vehicles (license_plate,vehicle_model) VALUES (?,?)",vehicle.getLicensePlate(),vehicle.getModel());



    }

    @Override
    public Vehicle getById(long id) {
        Long vId = id;
        return queryGet("SELECT * FROM Vehicles WHERE ID=?",vId);

    }

    @Override
    public void update(Vehicle vehicle) {

        executeQuery("UPDATE Vehicles SET license_plate = ?,  vehicle_model= ? WHERE id = ?", vehicle.getLicensePlate(), vehicle.getModel(), vehicle.getId());

    }

    @Override
    public void delete(Vehicle vehicle) {

        executeQuery("DELETE FROM Vehicles WHERE id = ?",vehicle.getId());
    }

    @Override
    public Vehicle getVehicleByUserId(long id) {

        Long userId = id;
        return queryGet("select * from vehicles where id = (select vehicle_id  from users where id = ?);",userId);

    }

    @Override
    public Vehicle getVehicleByLicensePlate(String lp) {
        return queryGet("SELECT * FROM Vehicles WHERE license_plate=?", lp);

    }

    @Override
    public Vehicle createAndGet(Vehicle vehicle) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vehicles (license_plate,vehicle_model) VALUES (?,?)",Statement.RETURN_GENERATED_KEYS)){

            preparedStatement.setString(1, vehicle.getLicensePlate());
            preparedStatement.setString(2,vehicle.getModel());


            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("Vehicle created successfully.");
            } else {
                LOGGER.info("Failed to create Vehicle.");
            }

            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                long generatedId = -1;
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);

                }
                vehicle.setId(generatedId);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return vehicle;
    }


}
