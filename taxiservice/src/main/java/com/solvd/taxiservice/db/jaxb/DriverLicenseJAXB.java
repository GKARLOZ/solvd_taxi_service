package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "driverLicense")
public class DriverLicenseJAXB {

    @XmlAttribute
    private long id;
    @XmlElement(name="licenseNumber")
    private String licenseNumber;
    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date dateOfBirth;

    @XmlJavaTypeAdapter(DateAdapter.class)
    private Date expirationDate;
    public DriverLicenseJAXB(){
        this.dateOfBirth = new Date();
        this.expirationDate = new Date();
    };

    public DriverLicenseJAXB(String licenseNumber, Date dateOfBirth, Date expirationDate) {
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
        return "DriverLicenseJAXB{" +
                "id=" + id +
                ", licenseNumber='" + licenseNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth.toString() +
                ", expirationDate=" + expirationDate.toString() +
                '}';
    }
}
