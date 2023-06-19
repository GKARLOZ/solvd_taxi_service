package com.solvd.taxiservice.db.service.manualimple;

import com.solvd.taxiservice.db.dao.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.IProfileDAO;
import com.solvd.taxiservice.db.dao.IUserDAO;
import com.solvd.taxiservice.db.dao.IVehicleDAO;
import com.solvd.taxiservice.db.dao.mysql.DriverLicenseDAO;
import com.solvd.taxiservice.db.dao.mysql.ProfileDAO;
import com.solvd.taxiservice.db.dao.mysql.UserDAO;
import com.solvd.taxiservice.db.dao.mysql.VehicleDAO;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.service.IUserService;


import java.util.List;


public class UserService implements IUserService{

        private IUserDAO userDAO = new UserDAO();
        private IDriverLicenseDAO driverLicenseDAO = new DriverLicenseDAO();
        private IProfileDAO profileDAO = new ProfileDAO();
        private IVehicleDAO vehicleDAO = new VehicleDAO();
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

            DriverLicense dl = driverLicenseDAO.createAndGet(user.getDriverLicense());
            Vehicle vehicle = vehicleDAO.createAndGet(user.getVehicle());
            Profile profile = profileDAO.createAndGet(user.getProfile());

            user.setDriverLicense(dl);
            user.setVehicle(vehicle);
            user.setProfile(profile);

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
