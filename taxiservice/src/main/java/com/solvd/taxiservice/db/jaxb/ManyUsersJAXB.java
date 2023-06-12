package com.solvd.taxiservice.db.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "users")
public class ManyUsersJAXB {
    @XmlElement(name="user")
    private List<UserJAXB> users = null;
    public ManyUsersJAXB(){};
    public ManyUsersJAXB(List<UserJAXB> users) {
        this.users = users;
    }

    public List<UserJAXB> getUsers() {
        return users;
    }

    public void setUsers(List<UserJAXB> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "ManyUsersJAXB{" +
                "users=" + users +
                '}';
    }
}
