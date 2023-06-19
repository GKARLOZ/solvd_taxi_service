package com.solvd.taxiservice.db.dao.mysql;

import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;

public class ProfileDAO implements IProfileDAO {

    private final static Logger LOGGER = LogManager.getLogger(Profile.class);


    private void executeQuery(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info(rowsAffected + " row affected in Profile table.");
            } else {
                LOGGER.info("No rows affected in Profile table");
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }

    }


    private Profile queryGet(String query, Object... params){

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();

        try(PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            for (int i = 0; i < params.length; i++) {
                preparedStatement.setObject(i + 1, params[i]);
            }

            try(ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    profile.setId(resultSet.getLong("id"));
                    profile.setName(resultSet.getString("name"));
                    profile.setPhoneNumber(resultSet.getString("phone"));
                }
            }

        } catch (SQLException e) {
            LOGGER.error(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return  profile;

    }






    @Override
    public Profile getById(long id) {
        Long profileId = id;
        return queryGet("SELECT * FROM Profiles WHERE ID=?", profileId);


    }
    @Override
    public void create(Profile profile) {

        executeQuery("INSERT INTO Profiles (name,phone) VALUES (?,?)", profile.getName(),profile.getPhoneNumber());

    }
    @Override
    public void update(Profile profile) {
        executeQuery("UPDATE profiles SET name = ?, phone = ? WHERE id = ?",profile.getName(),profile.getPhoneNumber(),profile.getId());

    }

    @Override
    public void delete(Profile profile) {
        executeQuery("DELETE FROM profiles WHERE id = ?", profile.getId());

    }

    @Override
    public Profile getProfileByUserId(long id) {

        Long profileId = id;
        return queryGet("select * from Profiles where id = (select profile_id  from users where id = ?);", profileId);


    }

    @Override
    public Profile getProfileByName(String Name) {

        return queryGet("select * from Profiles where name = ?;", Name);


    }

    @Override
    public Profile createAndGet(Profile profile) {

        Connection connection = DBConnectionPool.getInstance().getConnection();

        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Profiles (name,phone) VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);) {

            preparedStatement.setString(1, profile.getName());
            preparedStatement.setString(2, profile.getPhoneNumber());


            try(ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                long generatedId = -1;

                if (generatedKeys.next()) {
                    generatedId = generatedKeys.getLong(1);

                }
                profile.setId(generatedId);
            }

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                LOGGER.info("Profile created successfully.");
            } else {
                LOGGER.info("Failed to create profile.");
            }


        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }
        return profile;
    }
}
