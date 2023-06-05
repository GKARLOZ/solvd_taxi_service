package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.dao.*;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.mysql.*;



public class UserService {

        private IUserDAO userDAO = new UserDAO();
        private IDriverLicenseDAO driverLicenseDAO = new DriverLicenseDAO();
        private IProfileDAO profileDAO = new ProfileDAO();
        private IVehicleDAO vehicleDAO = new VehicleDAO();

        public User getUserById(int id){

            User user = userDAO.getById(id);
            DriverLicense dl = driverLicenseDAO.getDLByUserId(id);
            Vehicle vehicle = vehicleDAO.getVehicleByUserId(id);
            Profile profile = profileDAO.getProfileByUserId(id);

            user.setDriverLicense(dl);
            user.setVehicle(vehicle);
            user.setProfile(profile);

            return user;


        }
         public User getUserbyEmail(String email){

        User user = userDAO.getUserByEmail(email);
        int id = Integer.parseInt(user.getId());
        DriverLicense dl = driverLicenseDAO.getDLByUserId(id);
        Vehicle vehicle = vehicleDAO.getVehicleByUserId(id);
        Profile profile = profileDAO.getProfileByUserId(id);

        user.setDriverLicense(dl);
        user.setVehicle(vehicle);
        user.setProfile(profile);

        return user;


    }

}
