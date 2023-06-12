package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "user")
public class UserJAXB {

    @XmlAttribute
    private long id;
    @XmlElement(name="name")
    private String name;
    @XmlElement(name="email")
    private String email;

    @XmlElement(name = "driverLicense")
    private DriverLicenseJAXB driverLicenseJAXB;

    public UserJAXB(){
        this.driverLicenseJAXB = new DriverLicenseJAXB();
    }
    public UserJAXB(String name, String email, DriverLicenseJAXB driverLicenseJAXB) {
        this.name = name;
        this.email = email;
        this.driverLicenseJAXB = driverLicenseJAXB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DriverLicenseJAXB getDriverLicenseJAXB() {
        return driverLicenseJAXB;
    }

    public void setDriverLicenseJAXB(DriverLicenseJAXB driverLicenseJAXB) {
        this.driverLicenseJAXB = driverLicenseJAXB;
    }

    @Override
    public String toString() {
        return "UserJAXB{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", driverLicenseJAXB=" + driverLicenseJAXB +
                '}';
    }
}
