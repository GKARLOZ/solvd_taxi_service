package com.solvd.taxiservice.db.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection{

    public Connection connect( ) {

        Properties props = new Properties();
        Connection connection = null;
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            props.load(input);
            connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }


}
