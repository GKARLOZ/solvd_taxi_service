package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.User;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class UserDAO  implements IUserDAO {

    private final static Logger LOGGER = LogManager.getLogger(User.class);

    @Override
    public User getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return user;




    }

    @Override
    public void create(User user) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Users (email,profile_id, vehicle_id, driver_license) VALUES (?,?,?,?)");

            preparedStatement.setString(1, user.getEmail());
            preparedStatement.setLong(2,user.getProfile().getId());
            preparedStatement.setLong(3,user.getVehicle().getId());
            preparedStatement.setLong(4,user.getDriverLicense().getId());



            int rowsAffected = preparedStatement.executeUpdate();
            if (rowsAffected > 0) {
                LOGGER.info("User created successfully.");
            } else {
                LOGGER.info("Failed to create User.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }

    @Override
    public void update(User user) {




    }
    @Override
    public void delete(User user) {

    }

    @Override
    public User getUserByEmail(String email) {


        Connection connection = DBConnectionPool.getInstance().getConnection();
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE EMAIL=?");
            preparedStatement.setString(1,email);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return user;

    }

}
