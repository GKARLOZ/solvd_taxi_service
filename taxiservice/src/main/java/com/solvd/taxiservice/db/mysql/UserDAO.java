package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.model.User;
import com.solvd.taxiservice.db.utils.DBConnectionPool;


import java.sql.*;

public class UserDAO  implements IUserDAO {

    @Override
    public User getById(int id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        User user = new User();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM USERS WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                user.setId(resultSet.getString("id"));
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

                user.setId(resultSet.getString("id"));
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
