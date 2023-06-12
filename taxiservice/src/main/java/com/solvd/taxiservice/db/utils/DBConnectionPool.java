package com.solvd.taxiservice.db.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class DBConnectionPool {

    private final int POOL_SIZE = 5;
    private BlockingQueue<Connection> connections;
    private static DBConnectionPool instance;
    private int count = 0;

    private final static Logger LOGGER = LogManager.getLogger(DBConnectionPool.class);

    private DBConnectionPool() {
        this.connections = new ArrayBlockingQueue<>(POOL_SIZE);
    }

    public static DBConnectionPool getInstance(){
        if (instance == null) {
            synchronized (DBConnectionPool.class) {
                if (instance == null) {
                    instance = new DBConnectionPool();

                }
            }
        }
        return instance;
    }

    public synchronized Connection getConnection(){

        try {

            if(count < POOL_SIZE){
                count++;
                connections.offer(new DBConnection().connect());
                System.out.println(count);
            }

            return connections.take();

        } catch (InterruptedException e) {
            LOGGER.error(e);
        }
        return null;

    }

    public void releaseConnection(Connection connection){

        try{
            connections.put(connection);
        }catch (InterruptedException e ) {

            LOGGER.error(e);
        }

    }
    public synchronized void closeAllConnections() {

        for (Connection connection : connections) {
            try {
                connection.close();
            } catch (SQLException e) {
                LOGGER.error("Failed to close connection: " + e.getMessage());
            }
        }
        count = 0;
        connections.clear();
    }


}
