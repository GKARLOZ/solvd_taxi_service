package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.Main;
import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ProfileDAO implements IProfileDAO {

    private final static Logger LOGGER = LogManager.getLogger(Profile.class);

    @Override
    public Profile getById(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Profiles WHERE ID=?");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                profile.setId(resultSet.getLong("id"));
                profile.setName(resultSet.getString("name"));
                profile.setPhoneNumber(resultSet.getString("phone"));

            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return profile;
    }
    @Override
    public void create(Profile profile) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Profiles (name,phone) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);


            preparedStatement.setString(1,profile.getName());
            preparedStatement.setString(2,profile.getPhoneNumber());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Profile created successfully.");
            } else {
                LOGGER.info("Failed to create profile.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }
    @Override
    public void update(Profile profile) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("UPDATE profiles SET name = ?, phone = ? WHERE id = ?");

            preparedStatement.setString(1,profile.getName());
            preparedStatement.setString(2,profile.getPhoneNumber());
            preparedStatement.setLong(3, profile.getId());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Profile updated successfully.");
            } else {
                LOGGER.info("No Profile found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }


    }

    @Override
    public void delete(Profile profile) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("DELETE FROM profiles WHERE id = ?");

            preparedStatement.setLong(1,profile.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Profile deleted successfully.");
            } else {
                LOGGER.info("No Profile found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }

    @Override
    public Profile getProfileByUserId(long id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Profiles\n" +
                    "where id = (select profile_id  from users where id = ?);");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                profile.setId(resultSet.getLong("id"));
                profile.setName(resultSet.getString("name"));
                profile.setPhoneNumber(resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return profile;




    }

    @Override
    public Profile getProfileByName(String Name) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Profiles\n" +
                    "where name = ?;");
            preparedStatement.setString(1,Name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                profile.setId(resultSet.getLong("id"));
                profile.setName(resultSet.getString("name"));
                profile.setPhoneNumber(resultSet.getString("phone"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

        return profile;

    }

    @Override
    public Profile createProfile(Profile profile) {
        Connection connection = DBConnectionPool.getInstance().getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("INSERT INTO Profiles (name,phone) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getPhoneNumber());

            int rowsAffected = preparedStatement.executeUpdate();
            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            long generatedId = -1;

            if (generatedKeys.next()) {
                generatedId = generatedKeys.getLong(1);

            }
            profile.setId(generatedId);

            if (rowsAffected > 0) {
                LOGGER.info("Profile created successfully.");
            } else {
                LOGGER.info("Failed to create profile.");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return profile;
    }
}
