package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.dao.*;
//import com.solvd.taxiservice.db.dao.mysql.*;
import com.solvd.taxiservice.db.dao.mybatis.*;

// Change the import to mysql instead of mybatis to use MySql DAO.
public class DAOFactory {
    public static <T> T createDAO(String daoType) {
        String lowerCaseDaoType = daoType.toLowerCase();

        switch (lowerCaseDaoType) {
            case "vehicledao":
                return (T) new VehicleDAO();
            case "userdao":
                return (T) new UserDAO();
            case "tripdao":
                return (T) new TripDAO();
            case "ridetypedao":
                return (T) new RideTypeDAO();
            case "ridedao":
                return (T) new RideDAO();
            case "reviewdao":
                return (T) new ReviewDAO();
            case "driverlicensedao":
                return (T) new DriverLicenseDAO();
            case "profiledao":
                return (T) new ProfileDAO();
            default:
                throw new IllegalArgumentException("Invalid DAO type: " + daoType);
        }
    }
}
