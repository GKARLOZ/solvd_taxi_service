package com.solvd.taxiservice;

import com.solvd.taxiservice.db.dao.*;
import com.solvd.taxiservice.db.mysql.*;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.*;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
    public static void main(String[] args) {

        //----------------------------User Service-----------------------------------------
        User user = new UserService().getUserById(3);
        LOGGER.info(user);

        User user2 = new UserService().getUserbyEmail("asdfa@gmail.com");

        LOGGER.info(user2);


        //---------------------------ride service -------------------------------

        RideService rideService = new RideService();
        Ride ride = rideService.getRideById(1);
        List<Ride> rides = rideService.getRideByUserId(2);

        LOGGER.info(rides);
        //---------------------------Trip service---------------------------

        TripService tripService = new TripService();
        Trip trip = tripService.getTripById(1);

        LOGGER.info(trip);

        //---------------------Invoice Service------------------------

        InvoiceService invoiceService = new InvoiceService();
        Invoice invoice = invoiceService.getInvoiceById(1);

        LOGGER.info(invoice);

        //-------------------Payment service --------------------------

        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.getPaymentById(1);

        LOGGER.info(payment);

        //----------------------------------------------------


    }
}
