package com.solvd.taxiservice;

import com.solvd.taxiservice.db.mysql.UserDAO;
import com.solvd.taxiservice.db.model.*;
import com.solvd.taxiservice.db.utils.DBConnectionPool;

public class Main {

    public static void main(String[] args) {
        System.out.println("testing hello world");
        User user = new UserDAO().getById(1);
        System.out.println(user.getEmail());

    }
}
