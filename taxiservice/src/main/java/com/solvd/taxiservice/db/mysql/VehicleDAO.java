package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Vehicle;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.*;

public class VehicleDAO  implements IVehicleDAO {
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
                System.out.println("Vehicle created successfully.");
            } else {
                System.out.println("Failed to create Vehicle.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }


    }

    @Override
    public Vehicle getById(int id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Vehicles WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                vehicle.setId(resultSet.getString("id"));
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
            preparedStatement.setString(3,vehicle.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle updated successfully.");
            } else {
                System.out.println("No Vehicle found with the given ID.");
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

            preparedStatement.setString(1,vehicle.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Vehicle deleted successfully.");
            } else {
                System.out.println("Vehicle found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }


    }

    @Override
    public Vehicle getVehicleByUserId(int id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Vehicle vehicle = new Vehicle();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from vehicles\n" +
                    "where id = (select vehicle_id  from users where id = ?);");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                vehicle.setId(resultSet.getString("id"));
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

                vehicle.setId(resultSet.getString("id"));
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


}
