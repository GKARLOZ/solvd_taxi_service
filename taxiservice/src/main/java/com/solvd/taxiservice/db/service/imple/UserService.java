package com.solvd.taxiservice.db.service.imple;

import com.solvd.taxiservice.db.dao.*;
import com.solvd.taxiservice.db.dao.DAOFactory;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.IUserService;
//import com.solvd.taxiservice.db.dao.mysql.*;


import java.util.List;


public class UserService implements IUserService{

        private IUserDAO userDAO = DAOFactory.createDAO("USERDAO");
        private IDriverLicenseDAO driverLicenseDAO = DAOFactory.createDAO("driverLicenseDAO");
        private IProfileDAO profileDAO = DAOFactory.createDAO("PROFILEDAO");
        private IVehicleDAO vehicleDAO = DAOFactory.createDAO("VeHICLEdao");
        private RideService rideService = new RideService();


        @Override
        public User getById(long id){

            User user = userDAO.getById(id);
            DriverLicense dl = driverLicenseDAO.getDLByUserId(id);
            Vehicle vehicle = vehicleDAO.getVehicleByUserId(id);
            Profile profile = profileDAO.getProfileByUserId(id);
           List<Ride> rides = rideService.getRideByUserId(id);

            user.setDriverLicense(dl);
            user.setVehicle(vehicle);
            user.setProfile(profile);
            user.setRides(rides);

            return user;


        }
        @Override
         public User getUserbyEmail(String email){

        User user = userDAO.getUserByEmail(email);
        long id = user.getId();
        DriverLicense dl = driverLicenseDAO.getDLByUserId(id);
        Vehicle vehicle = vehicleDAO.getVehicleByUserId(id);
        Profile profile = profileDAO.getProfileByUserId(id);
        List<Ride> rides = rideService.getRideByUserId(id);

        user.setDriverLicense(dl);
        user.setVehicle(vehicle);
        user.setProfile(profile);
        user.setRides(rides);

        return user;


    }
    @Override
    public void create(User user){


//            DriverLicense dl = driverLicenseDAO.createAndGet(user.getDriverLicense());
//            Vehicle vehicle = vehicleDAO.createAndGet(user.getVehicle());
//            Profile profile = profileDAO.createAndGet(user.getProfile());

//            user.setDriverLicense(dl);
//            user.setVehicle(vehicle);
//            user.setProfile(profile);

        driverLicenseDAO.create(user.getDriverLicense());
        vehicleDAO.create(user.getVehicle());
        profileDAO.create(user.getProfile());
        userDAO.create(user);


    }
    @Override
    public void delete(User user){

                userDAO.delete(user);
                driverLicenseDAO.delete(user.getDriverLicense());
                vehicleDAO.delete(user.getVehicle());
                profileDAO.delete(user.getProfile());

    }

    @Override
    public void update(User user){

            userDAO.update(user);

    }




}
