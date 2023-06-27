package com.solvd.taxiservice.db.model;

import com.fasterxml.jackson.annotation.*;

import java.util.Date;

@JsonRootName(value="Driver_License")
public class DriverLicense {

    @JsonIgnore
    private long id;
    @JsonProperty("License_Number")
    private String licenseNumber;
    @JsonProperty("Date_Of_Birth")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dateOfBirth;
    @JsonProperty("Expiration_Date")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date expirationDate;

    public DriverLicense(){

        this.dateOfBirth = new Date();
        this.expirationDate = new Date();

    };

    public DriverLicense(String licenseNumber, Date dateOfBirth, Date expirationDate) {

        this.licenseNumber = licenseNumber;
        this.dateOfBirth = dateOfBirth;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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
