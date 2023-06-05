package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Vehicle;

public interface IVehicleDAO extends IDAO<Vehicle>{

    public Vehicle getVehicleByUserId(int id);
    public Vehicle getVehicleByLicensePlate(String lp);
}
