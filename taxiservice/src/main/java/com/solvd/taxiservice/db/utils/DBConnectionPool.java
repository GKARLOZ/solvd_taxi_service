package com.solvd.taxiservice.db.utils;

import java.sql.Connection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class DBConnectionPool {

        private final int POOL_SIZE = 5;
        private BlockingQueue<Connection> connections;
        private static DBConnectionPool instance;
        //private final static Logger LOGGER = LogManager.getLogger(DBConnectionPool.class);

        private DBConnectionPool() {
            connections = new ArrayBlockingQueue<>(POOL_SIZE);
            initializePool();
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


        private void initializePool() {
            for (int i = 0; i < POOL_SIZE; i++) {
                Connection connection = new DBConnection().connect();
                connections.offer(connection);
            }

        }

        public synchronized Connection getConnection(){

            try {

                return  connections.take();

            } catch (InterruptedException e) {

                throw new RuntimeException(e);
            }


        }

        public void releaseConnection(Connection connection){

            try{
                connections.put(connection);


            }catch (InterruptedException e ) {

                //LOGGER.error(e.getMessage());
                }

        }

}
