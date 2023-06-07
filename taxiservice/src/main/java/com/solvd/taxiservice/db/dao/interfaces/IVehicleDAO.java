package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Vehicle;

public interface IVehicleDAO extends IDAO<Vehicle> {

    public Vehicle getVehicleByUserId(long id);
    public Vehicle getVehicleByLicensePlate(String lp);

    public Vehicle createVehicle(Vehicle vehicle);
}
