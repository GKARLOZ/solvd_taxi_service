package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.interfaces.IDriverLicenseDAO;
import com.solvd.taxiservice.db.model.DriverLicense;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.sql.Date;

import java.sql.*;

public class DriverLicenseDAO implements IDriverLicenseDAO {

    private final static Logger LOGGER = LogManager.getLogger(DriverLicense.class);

    private void executeQuery(String query, Object... params) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in DL table.");
            } else {
                LOGGER.info("No rows affected in DL table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    private DriverLicense queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();

        DriverLicense dl = new DriverLicense();

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    dl.setId(resultSet.getLong("id"));
                    dl.setLicenseNumber(resultSet.getString("license_number"));
                    dl.setDateOfBirth(resultSet.getDate("date_of_birth"));
                    dl.setExpirationDate(resultSet.getDate("expiration_date"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return dl  ;

    }

    @Override
    public void create(DriverLicense driverLicense) {
        executeQuery("INSERT INTO driver_licenses (license_number,date_of_birth,expiration_date) VALUES (?,?,?)",driverLicense.getLicenseNumber(), new Date(driverLicense.getDateOfBirth().getTime()),new Date(driverLicense.getExpirationDate().getTime()));

    }

    @Override
    public DriverLicense getById(long id) {
        Long dlId = id;
        return queryGet("SELECT * FROM driver_licenses WHERE ID=?",dlId);

    }

    @Override
    public void update(DriverLicense driverLicense) {

        executeQuery("UPDATE driver_licenses SET license_number = ?,  date_of_birth= ?, expiration_date=? WHERE id = ?", driverLicense.getLicenseNumber(),(Date)driverLicense.getDateOfBirth(), (Date)driverLicense.getExpirationDate(),driverLicense.getId());

    }

    @Override
    public void delete(DriverLicense driverLicense) {

        executeQuery("DELETE FROM driver_licenses WHERE id = ?",driverLicense.getId());

    }

    @Override
    public DriverLicense getDLByUserId(long id) {
        Long userId = id;
        return queryGet("select * from driver_licenses where id = (select driver_license_id from users where id = ?);",userId);

    }

    @Override
    public DriverLicense getDLByLicenseNumber(String licenseNumber) {

        return queryGet("SELECT * FROM driver_licenses WHERE license_number=?",licenseNumber);

    }

    @Override
    public DriverLicense createAndGet(DriverLicense driverLicense) {

        Connection connection = DBConnectionPool.getInstance().getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO driver_licenses (license_number,date_of_birth,expiration_date) VALUES (?,?,?)",Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, driverLicense.getLicenseNumber());
            preparedStatement.setDate(2, new Date(driverLicense.getDateOfBirth().getTime()));
            preparedStatement.setDate(3, new Date(driverLicense.getExpirationDate().getTime()));

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("License created successfully.");
            } else {
                LOGGER.info("Failed to create Driver License.");
            }

            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {

                long generatedId = -1;
                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);
                }
                driverLicense.setId(generatedId);
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return driverLicense;
    }
}
