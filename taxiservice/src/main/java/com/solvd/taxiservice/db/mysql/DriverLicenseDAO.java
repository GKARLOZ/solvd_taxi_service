package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.dao.IDriverLicenseDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class DriverLicenseDAO implements IDriverLicenseDAO {

    private final static Logger LOGGER = LogManager.getLogger(DriverLicense.class);
    @Override
    public void create(DriverLicense driverLicense) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO driver_licenses (license_number,date_of_birth,expiration_date) VALUES (?,?,?)");

            preparedStatement.setString(1, driverLicense.getLicenseNumber());
            preparedStatement.setDate(2, new java.sql.Date(driverLicense.getDateOfBirth().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(driverLicense.getExpirationDate().getTime()));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("License created successfully.");
            } else {
                LOGGER.info("Failed to create Driver License.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }

    @Override
    public DriverLicense getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        DriverLicense dl = new DriverLicense();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM driver_licenses WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                dl.setId(resultSet.getLong("id"));
                dl.setLicenseNumber(resultSet.getString("license_number"));
                dl.setDateOfBirth(resultSet.getDate("date_of_birth"));
                dl.setExpirationDate(resultSet.getDate("expiration_date"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return dl ;
    }

    @Override
    public void update(DriverLicense driverLicense) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE driver_licenses SET license_number = ?,  date_of_birth= ?, expiration_date=? WHERE id = ?");

            preparedStatement.setString(1,driverLicense.getLicenseNumber());
            preparedStatement.setDate(2, (Date) driverLicense.getDateOfBirth());
            preparedStatement.setDate(3, (Date) driverLicense.getExpirationDate());
            preparedStatement.setLong(4,driverLicense.getId());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Driver License updated successfully.");
            } else {
                LOGGER.info("No Driver License found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }

    @Override
    public void delete(DriverLicense driverLicense) {


        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM driver_licenses WHERE id = ?");

            preparedStatement.setLong(1,driverLicense.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Driver License deleted successfully.");
            } else {
                LOGGER.info("No Driver License found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }

    @Override
    public DriverLicense getDLByUserId(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        DriverLicense dl = new DriverLicense();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from driver_licenses\n" +
                    "where id = (select driver_license_id from users where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                dl.setId(resultSet.getLong("id"));
                dl.setLicenseNumber(resultSet.getString("license_number"));
                dl.setDateOfBirth(resultSet.getDate("date_of_birth"));
                dl.setExpirationDate(resultSet.getDate("expiration_date"));

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return dl;

    }

    @Override
    public DriverLicense getDLByLicenseNumber(String licenseNumber) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        DriverLicense dl = new DriverLicense();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM driver_licenses WHERE license_number=?");
            preparedStatement.setString(1,licenseNumber);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                dl.setId(resultSet.getLong("id"));
                dl.setLicenseNumber(resultSet.getString("license_number"));
                dl.setDateOfBirth(resultSet.getDate("date_of_birth"));
                dl.setExpirationDate(resultSet.getDate("expiration_date"));


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return dl ;
    }

    @Override
    public DriverLicense createDL(DriverLicense driverLicense) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO driver_licenses (license_number,date_of_birth,expiration_date) VALUES (?,?,?)");

            preparedStatement.setString(1, driverLicense.getLicenseNumber());
            preparedStatement.setDate(2, new java.sql.Date(driverLicense.getDateOfBirth().getTime()));
            preparedStatement.setDate(3, new java.sql.Date(driverLicense.getExpirationDate().getTime()));


            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("License created successfully.");
            } else {
                LOGGER.info("Failed to create Driver License.");
            }

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            long generatedId = -1;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);

            }
            driverLicense.setId(generatedId);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return driverLicense;
    }
}
