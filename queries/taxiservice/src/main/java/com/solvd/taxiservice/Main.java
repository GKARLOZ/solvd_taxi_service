package com.solvd.taxiservice;

import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.*;
import com.solvd.taxiservice.db.service.implement.*;
import com.solvd.taxiservice.db.xml.parsers.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

import static com.solvd.taxiservice.db.xml.XSDValidator.validateXMLSchema;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
   public static void main(String[] args) {


          task16();
          //task15();

    }

    public static void task16(){
//        Create one XML file and XSD schema for at least 5 classes from the below hierarchy.
//        Validate XML file using XSD schema and assigned parser.
//        Parse XML file using one of the parsers from the title.

          String [] fileList = {"Vehicle.xsd", "Vehicle.xml"};

         if(fileList.length !=2) {
             LOGGER.info("Usage : XSDValidator <file-name.xsd> <file-name.xml>");
         } else {
              boolean isValid = validateXMLSchema(fileList[0],fileList[1]);

              if(isValid) {
                  LOGGER.info(fileList[1] + " is valid against " + fileList[0]);
              } else {
                  LOGGER.info(fileList[1] + " is not valid against " + fileList[0]);
              }

              VehicleParser vp = new VehicleParser();
              vp.parse(fileList[1]);

         }

    }

    public static void task15(){

         //----------------------------User Service-----------------------------------------
        User user = new UserService().getById(3);
        LOGGER.info(user);

        User user2 = new UserService().getUserbyEmail("asdfa@gmail.com");



        //---------------------------ride service -------------------------------

        RideService rideService = new RideService();
        Ride ride = rideService.getById(1);
        List<Ride> rides = rideService.getRideByUserId(2);

        LOGGER.info(rides);
        //---------------------------Trip service---------------------------

        TripService tripService = new TripService();
        Trip trip = tripService.getTripById(1);

        LOGGER.info(trip);

        //---------------------Invoice Service------------------------

        InvoiceService invoiceService = new InvoiceService();
        Invoice invoice = invoiceService.getById(1);

        LOGGER.info(invoice);

        //-------------------Payment service --------------------------

        PaymentService paymentService = new PaymentService();
        Payment payment = paymentService.getById(1);

        LOGGER.info(payment);
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


    }


}
