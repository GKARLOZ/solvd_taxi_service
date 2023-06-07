package com.solvd.taxiservice.db.service.implement;

import com.solvd.taxiservice.db.dao.interfaces.IDriverLicenseDAO;
import com.solvd.taxiservice.db.dao.interfaces.IProfileDAO;
import com.solvd.taxiservice.db.dao.interfaces.IUserDAO;
import com.solvd.taxiservice.db.dao.interfaces.IVehicleDAO;
import com.solvd.taxiservice.db.dao.mysql.DriverLicenseDAO;
import com.solvd.taxiservice.db.dao.mysql.ProfileDAO;
import com.solvd.taxiservice.db.dao.mysql.UserDAO;
import com.solvd.taxiservice.db.dao.mysql.VehicleDAO;
import com.solvd.taxiservice.db.model.*;


import java.util.List;


public class UserService {

        private IUserDAO userDAO = new UserDAO();
        private IDriverLicenseDAO driverLicenseDAO = new DriverLicenseDAO();
        private IProfileDAO profileDAO = new ProfileDAO();
        private IVehicleDAO vehicleDAO = new VehicleDAO();
        private RideService rideService = new RideService();

        public User getUserById(int id){

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

    public void createUser(User user){

            DriverLicense dl = driverLicenseDAO.createDL(user.getDriverLicense());
            Vehicle vehicle = vehicleDAO.createVehicle(user.getVehicle());
            Profile profile = profileDAO.createProfile(user.getProfile());

            user.setDriverLicense(dl);
            user.setVehicle(vehicle);
            user.setProfile(profile);

            userDAO.create(user);


    }

    public void delete(User user){

                userDAO.delete(user);
                driverLicenseDAO.delete(user.getDriverLicense());
                vehicleDAO.delete(user.getVehicle());
                profileDAO.delete(user.getProfile());

    }

    public void update(User user){

            userDAO.update(user);

    }




}
