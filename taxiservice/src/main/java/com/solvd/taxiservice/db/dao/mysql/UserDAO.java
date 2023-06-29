package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.model.User;
import com.solvd.taxiservice.db.model.UserBuilder;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.sql.*;

public class UserDAO  implements IUserDAO {

    private final static Logger LOGGER = LogManager.getLogger(User.class);
    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in User table.");
            } else {
                LOGGER.info("No rows affected in User table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }
    private User queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        User user = new UserBuilder().build();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {


            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    user.setId(resultSet.getLong("id"));
                    user.setEmail(resultSet.getString("email"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return user  ;

    }

    @Override
    public User getById(long id) {
        Long userId = id;
        return queryGet("SELECT * FROM USERS WHERE ID=?",userId);

    }

    @Override
    public void create(User user) {
        executeQuery("INSERT INTO Users (email,profile_id, vehicle_id, driver_license_id) VALUES (?,?,?,?)", user.getEmail(),user.getProfile().getId(),user.getVehicle().getId(),user.getDriverLicense().getId());

    }

    @Override
    public void update(User user) {
        executeQuery("UPDATE Users SET email = ? WHERE id = ?",user.getEmail(),user.getId());

    }
    @Override
    public void delete(User user) {
        executeQuery("DELETE FROM users WHERE id = ?",user.getId());
    }

    @Override
    public User getUserByEmail(String email) {

        return queryGet("SELECT * FROM USERS WHERE EMAIL=?",email);


    }

}
