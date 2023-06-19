package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.model.User;

public interface IUserService extends IService<User>{

    public User getUserbyEmail(String email);
}
