package com.solvd.taxiservice;

import com.solvd.taxiservice.db.dao.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.mysql.DriverLicenseDAO;
import com.solvd.taxiservice.db.mysql.ProfileDAO;
import com.solvd.taxiservice.db.mysql.UserDAO;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.mysql.VehicleDAO;
import com.solvd.taxiservice.db.service.UserService;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

//        User user = new UserDAO().getById(1);
//        System.out.println(user.getEmail());

//        DriverLicense dl = new DriverLicenseDAO().getDLByUserId(2);
//        System.out.println(dl.getLicenseNumber());
//
//        Vehicle v = new VehicleDAO().getVehicleByUserId(4);
//        System.out.println(v.getLicensePlate());
//
//        Profile p = new ProfileDAO().getProfileByUserId(4);
//        System.out.println(p.getName());
//---------------------------------------------------------------------
//        User user = new UserService().getUserById(3);
//        System.out.println(user);
//
//        User user2 = new UserService().getUserbyEmail("asdfa@gmail.com");
//        System.out.println(user2);
//----------------------------------------------------------------
//        IProfileDAO pdao = new ProfileDAO();
//        Profile p = pdao.getById(2);
//        System.out.println(p);
//        p.setPhoneNumber("(222)222-2222");
//        pdao.update(p);
//
//        Profile p2 = pdao.getById(2);
//        System.out.println(p2);
//-------------------------------------------------------
//        IProfileDAO pdao = new ProfileDAO();
//       Profile p = new Profile("","Ed","(777)888-888");
//        pdao.create(p);
//
//        Profile p2 = pdao.getProfileByName("Ed");
//        System.out.println(p2);

        //-------------------------------------------------------
//        IProfileDAO pdao = new ProfileDAO();
//       Profile p = pdao.getProfileByName("johny");
//        System.out.println(p);
//        pdao.delete(p);
//
//        Profile p2 = pdao.getProfileByName("johny");
//        System.out.println(p2);

//------------------------DL DAO--------------------------------------------------

//        IDriverLicenseDAO dlDAO = new DriverLicenseDAO();
//        Date d = new Date();
//        DriverLicense dl;
//
//        dl = new DriverLicense("","4R4R4R",d,d);
//        dlDAO.create(dl);
//
//        dl = dlDAO.getDLByLicenseNumber("4R4R4R");
//        System.out.println(dl);
//
//        dl.setLicenseNumber("5R45F");
//        dlDAO.update(dl);
//
//        dl = dlDAO.getById(Integer.parseInt(dl.getId()));
//        System.out.println(dl);
//
//        dlDAO.delete(dl);
//        dl = dlDAO.getDLByLicenseNumber("5R45F");
//
//        System.out.println(dl);

//----------------VEHICLE DAO
        IVehicleDAO vehicleDAO = new VehicleDAO();
        Vehicle vehicle;
        vehicle = new Vehicle("","BMW","4jgrt4");

        vehicleDAO.create(vehicle);

        vehicle = vehicleDAO.getVehicleByLicensePlate("4jgrt4");
        System.out.println(vehicle);

        vehicle.setLicensePlate("5try3");
        vehicleDAO.update(vehicle);

        vehicle = vehicleDAO.getById(Integer.parseInt(vehicle.getId()));
        System.out.println(vehicle);

        vehicleDAO.delete(vehicle);
        vehicle = vehicleDAO.getVehicleByLicensePlate("5try3");

        System.out.println(vehicle);





    }
}
