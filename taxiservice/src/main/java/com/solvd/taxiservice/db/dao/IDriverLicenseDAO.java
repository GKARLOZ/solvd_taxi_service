package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.DriverLicense;

public interface IDriverLicenseDAO extends IDAO<DriverLicense> {

    public DriverLicense getDLByUserId(long id);
    public DriverLicense getDLByLicenseNumber(String licenseNumber);

    public DriverLicense createDL(DriverLicense driverLicense);
}
