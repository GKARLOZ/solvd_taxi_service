package com.solvd.taxiservice.db.mysql;

import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.model.Profile;
import com.solvd.taxiservice.db.model.User;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProfileDAO implements IProfileDAO {

    @Override
    public Profile getById(int id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM Profiles WHERE ID=?");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                profile.setId(resultSet.getString("id"));
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
            preparedStatement = connection.prepareStatement("INSERT INTO Profiles (name,phone) VALUES (?,?)");

            preparedStatement.setString(1,profile.getName());
            preparedStatement.setString(2,profile.getPhoneNumber());
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Profile created successfully.");
            } else {
                System.out.println("Failed to create profile.");
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
            preparedStatement.setInt(3, Integer.parseInt(profile.getId()));
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Profile updated successfully.");
            } else {
                System.out.println("No Profile found with the given ID.");
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

            preparedStatement.setString(1,profile.getId());

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Profile deleted successfully.");
            } else {
                System.out.println("No Profile found with the given ID.");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            DBConnectionPool.getInstance().releaseConnection(connection);
        }



    }

    @Override
    public Profile getProfileByUserId(int id) {

        Connection connection = DBConnectionPool.getInstance().getConnection();
        Profile profile = new Profile();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("select * from Profiles\n" +
                    "where id = (select profile_id  from users where id = ?);");
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){

                profile.setId(resultSet.getString("id"));
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

                profile.setId(resultSet.getString("id"));
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
}
