package com.solvd.taxiservice.db.model;

import java.util.Date;

public class DriverLicense {

    private String id;
    private String licenseNumber;
    private Date dateOfBirth;
    private Date expirationDate;

    public DriverLicense(){};

    public DriverLicense(String id, String licenseNumber, Date dateOfBirth, Date expirationDate) {
        this.id = id;
        this.licenseNumber = licenseNumber;
        this.dateOfBirth = dateOfBirth;
        this.expirationDate = expirationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "DriverLicense{" +
                "id='" + id + '\'' +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
