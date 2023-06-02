package com.solvd.taxiservice;

import java.util.Date;

public class DriverLicense {

    private String licenseNumber;
    private Date dateOfBirth;
    private Date expirationDate;

    public DriverLicense(){};

    public DriverLicense(String licenseNumber, Date dateOfBirth, Date expirationDate) {
        this.licenseNumber = licenseNumber;
        this.dateOfBirth = dateOfBirth;
        this.expirationDate = expirationDate;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }
}
