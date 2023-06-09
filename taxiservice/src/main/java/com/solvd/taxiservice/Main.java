package com.solvd.taxiservice;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.taxiservice.db.behavioral.ICalculateFareStrategy;
import com.solvd.taxiservice.db.behavioral.StandardRideTypeStrategy;
import com.solvd.taxiservice.db.controller.UserController;
import com.solvd.taxiservice.db.structural.*;
import com.solvd.taxiservice.db.jaxb.ManyUsersJAXB;
import com.solvd.taxiservice.db.jaxb.DriverLicenseJAXB;
import com.solvd.taxiservice.db.jaxb.JAXB;
import com.solvd.taxiservice.db.jaxb.UserJAXB;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.behavioral.RideCostObserver;
import com.solvd.taxiservice.db.service.IRideService;
import com.solvd.taxiservice.db.service.IUserService;
import com.solvd.taxiservice.db.service.imple.*;
import com.solvd.taxiservice.db.stax.parsers.*;
import com.solvd.taxiservice.db.utils.DBConnectionPool;
import com.solvd.taxiservice.db.view.UserView;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import static com.solvd.taxiservice.db.stax.XSDValidator.validateXMLSchema;

public class Main {

    private final static Logger LOGGER = LogManager.getLogger(Main.class);
   public static void main(String[] args) {

       task20();
//       task19();
//       task18();
//       task17();
//       task16();
//       task15();
//       multiThread();


    }
    public static void task20(){
//   Add Factory, Abstract Factory, Builder, Listener, Facade, Decorator, Proxy, Strategy, MVC patterns to your current project. (confirm assignments with your mentors)
//   Refactor code for the current project to satisfy SOLID principles.

       //Observer(Listener)
       RideType rt = new RideType("luxury",4.50);
       new RideCostObserver(rt);
       LOGGER.info(rt);
       rt.setCostPerMile(5.50);

       //Decorator
        IRideType unlimitedStopsRide = new AddStopsRideType(new StandardRideType());
        unlimitedStopsRide.includeToRide();
        IRideType mediaRide = new TSRideType(new AddStopsRideType(new StandardRideType()));
        mediaRide.includeToRide();
        IRideType mediaRide2 = new TSRideType(new StandardRideType());
        mediaRide2.includeToRide();

        //Strategy
        StandardRideType standardType = new StandardRideType();
        ICalculateFareStrategy iCal = new StandardRideTypeStrategy();
        standardType.setRideTypeStrategy(iCal, standardType.getCostPerMile());

        //Proxy
        IRideType iRideType = new RideTypeProxy();
        iRideType.includeToRide();

        //Facade
        RideTypeFacade rtf = new RideTypeFacade();
        rtf.useComboB();
        rtf.useComboD();

       //Builders
       Ride ride  = new RideBuilder()
               .withRideType(rt)
               .withPickUpLocations("abc street")
               .withDropOffLocation("zxy street")
               .createRide();

       LOGGER.info(ride);

        User user = new UserBuilder()
                .withId(11)
                .withEmail("Email@gmail.com")
                .withProfile(new Profile("Charlie","123123123"))
                .withDriverLicense(new DriverLicense())
                .withVehicle(new Vehicle("Jeep","Q123f3"))
                .build();

        LOGGER.info(user);

        //mvn
        UserView userView = new UserView();
        UserController userController = new UserController(user, userView);
        userController.updateView();
        userController.setEmail("hello@gmail.com");
        userController.updateView();



    }
    public static void task19(){
//        Add MyBatis DAOs to the existing hierarchy with the same requirements. Choose any XML or interface mapping.
//        Switch service classes to MyBatis.

        //----------------------------User Service myBatis-----------------------------------------
        IUserService userService = new UserService();
        User user = userService.getUserbyEmail("myEmail@gmail.com");
        LOGGER.info(user);

//      //------------------------------Ride Service myBatis--------------------------------------
        IRideService rideService = new RideService();
        Ride ride = rideService.getById(2);
        LOGGER.info(ride);


    }
    public static void task18(){
//        Create one Json file for at least 5 classes from the hierarchy.
//        Add Jackson’s annotation to the hierarchy. Date, List, and complex objects should be covered.
//        Parse JSON using Jackson.

        Profile profile = new Profile();
        profile.setName("Johnny");
        profile.setPhoneNumber("911");

        DriverLicense driverLicense = new DriverLicense();
        driverLicense.setLicenseNumber("234werwe324");

        Vehicle vehicle = new Vehicle();
        vehicle.setModel("Jeep");
        vehicle.setLicensePlate("24l3j");

        List<Ride> rides = new ArrayList<>();
        Ride rideOne = new RideBuilder().createRide();
        rideOne.setPickUpLocations("123 Circle street");
        rideOne.setDropOffLocation("32 Hollywood Blvd");
        Ride rideTwo = new RideBuilder().createRide();
        rideTwo.setPickUpLocations("24 Fire street");
        rideTwo.setDropOffLocation("74453 Main ave");
        rides.add(rideOne);
        rides.add(rideTwo);
        rides.add(rideOne);

        User user = new UserBuilder().build();
        user.setId(11);
        user.setEmail("email@gmail.com");

        user.setProfile(profile);
        user.setDriverLicense(driverLicense);
        user.setRides(rides);
        user.setVehicle(vehicle);


        ObjectMapper mapper = new ObjectMapper();
        try {
            //serialize
            mapper.enable(SerializationFeature.WRAP_ROOT_VALUE, SerializationFeature.INDENT_OUTPUT);
            mapper.writeValue(new File("src/main/resources/results.json"),user);

            //deserialize
            mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            User deserializeUser = mapper.readValue(new File("src/main/resources/results.json"), User.class);
            LOGGER.info(deserializeUser.toString());

        } catch (IOException e) {
            LOGGER.error(e);
        }


    }
    public static void task17(){
//        Add JAXB annotations to the hierarchy. Date, List, and complex objects should be covered.
//        Parse XML using JAXB.

        try {
            ManyUsersJAXB users = new ManyUsersJAXB();
            users.setUsers(new ArrayList<>());

            DriverLicenseJAXB dl = new DriverLicenseJAXB();
            dl.setLicenseNumber("434rwf34wr2g");
            UserJAXB user = new UserJAXB("johnny","email@gmali.com",dl);
            users.getUsers().add(user);

            DriverLicenseJAXB dlTwo = new DriverLicenseJAXB();
            dlTwo.setLicenseNumber("23423ewrq");
            UserJAXB userTwo = new UserJAXB("juanito","yeah@gmali.com",dl);
            users.getUsers().add(userTwo);

            DriverLicenseJAXB dlThree = new DriverLicenseJAXB();
            dlThree.setLicenseNumber("67867gsgfa");
            UserJAXB userThree = new UserJAXB("jj","jj@gmali.com",dl);
            users.getUsers().add(userThree);

            JAXB jaxb = new JAXB();
            jaxb.marshal(users);
            LOGGER.info(jaxb.unmarshal());

        } catch (JAXBException e) {
            LOGGER.error(e);
        } catch (FileNotFoundException e) {
            LOGGER.error(e);
        }


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
    public static void multiThread(){

        Thread client2 = new Thread(() -> {
            try {

                Connection conn = DBConnectionPool.getInstance().getConnection();
                LOGGER.info(Thread.currentThread().getName() + ": Get Connection successful.");
                Thread.sleep(1000);
                DBConnectionPool.getInstance().releaseConnection(conn);
                LOGGER.info(Thread.currentThread().getName() + ": Release Connection successful.");

            } catch (InterruptedException e) {
                LOGGER.error(e.getMessage());
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(7);
        ;
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.execute(client2);
        executorService.shutdown();

   }

}
