package com.solvd.taxiservice.db.utils;

import com.solvd.taxiservice.Main;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DBConnection{
    private final static Logger LOGGER = LogManager.getLogger(DBConnection.class);
    public Connection connect( ) {

        Properties props = new Properties();
        Connection connection = null;
        try (InputStream input = new FileInputStream("src/main/resources/db.properties")) {
            props.load(input);
            connection = DriverManager.getConnection(props.getProperty("db.url"), props.getProperty("db.user"), props.getProperty("db.password"));

        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        } catch (IOException e) {
            LOGGER.error(e);
        } catch (SQLException e) {
            LOGGER.error(e);
        }
        return connection;
    }


}
