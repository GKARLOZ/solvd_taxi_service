package com.solvd.taxiservice;

import com.solvd.taxiservice.db.dao.interfaces.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.interfaces.IProfileDAO;
import com.solvd.taxiservice.db.dao.interfaces.IUserDAO;
import com.solvd.taxiservice.db.dao.interfaces.IVehicleDAO;
import com.solvd.taxiservice.db.dao.mysql.DriverLicenseDAO;
import com.solvd.taxiservice.db.dao.mysql.ProfileDAO;
import com.solvd.taxiservice.db.dao.mysql.UserDAO;
import com.solvd.taxiservice.db.dao.mysql.VehicleDAO;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.implement.*;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
   public static void main(String[] args) {
//
//        //----------------------------User Service-----------------------------------------
//        User user = new UserService().getUserById(3);
//        LOGGER.info(user);
//
//        User user2 = new UserService().getUserbyEmail("asdfa@gmail.com");
//
//        LOGGER.info(user2);


//
//
//        //---------------------------ride service -------------------------------
//
//        RideService rideService = new RideService();
//        Ride ride = rideService.getRideById(1);
//        List<Ride> rides = rideService.getRideByUserId(2);
//
//        LOGGER.info(rides);
//        //---------------------------Trip service---------------------------
//
//        TripService tripService = new TripService();
//        Trip trip = tripService.getTripById(1);
//
//        LOGGER.info(trip);
//
//        //---------------------Invoice Service------------------------
//
//        InvoiceService invoiceService = new InvoiceService();
//        Invoice invoice = invoiceService.getInvoiceById(1);
//
//        LOGGER.info(invoice);

//        //-------------------Payment service --------------------------
//
//        PaymentService paymentService = new PaymentService();
//        Payment payment = paymentService.getPaymentById(1);
//
//        LOGGER.info(payment);
//
//        //------------------Profile DAO ----------------------------------

//        IProfileDAO profileDAO = new ProfileDAO();
//        Profile profile = new Profile("Prana", "(323)234-1234");
//        profile = profileDAO.getProfileByName("Prana");
////        profileDAO.create(profile);
//        profile.setName("Mario");
//        //profileDAO.update(profile);
//
//        profile = profileDAO.getProfileByName("Mario");
//        profileDAO.delete(profile);

//        System.out.println(profileDAO.getById(1));
//        System.out.println(profileDAO.getProfileByName("Eddy"));
//        System.out.println(profileDAO.getProfileByUserId(2));

//--------------------------DL DAO--------------------------------------------
//        IDriverLicenseDAO driverLicenseDAO = new DriverLicenseDAO();
//        DriverLicense dl = driverLicenseDAO.getDLByUserId(2);
////        dl.setLicenseNumber("1111111111111");
////        driverLicenseDAO.create(dl);
//
//        dl = driverLicenseDAO.getDLByLicenseNumber("deg11wew11");
//        dl.setLicenseNumber("deg11wew11");
//
//        //driverLicenseDAO.update(dl);
//        driverLicenseDAO.delete(dl);
//        System.out.println(dl);

//------------------------VEHICLE DAO-----------------------------------------------------
//        IVehicleDAO vehicleDAO = new VehicleDAO();
//        Vehicle vehicle = vehicleDAO.getById(1);
//        System.out.println(vehicle);
//
//        vehicleDAO.create(vehicle);
//
//        System.out.println(vehicle = vehicleDAO.getById(1));
//
//        vehicle.setLicensePlate("94ghy6");
//        vehicleDAO.update(vehicle);
//        vehicle = vehicleDAO.getVehicleByLicensePlate("9999999");
//       vehicleDAO.delete(vehicle);
//        System.out.println(vehicle);
//------------------------------------------------------------------------------

//       User user3 = new User();
//
//       UserService userService = new UserService();
//
//       //userService.createUser(user3);
//
//       IUserDAO userDAO = new UserDAO();
//       user3 = userService.getUserById(4);
//       System.out.println(user3);
//       user3.setEmail("a@gmail.com");
//       userService.update(user3);
//
//        userDAO.delete(user3);
//
//       IVehicleDAO vehicleDAO = new VehicleDAO();
//
//       vehicleDAO.delete(vehicleDAO.getVehicleByUserId(user3.getId()));
//       userService.delete(user3);









    }
}
