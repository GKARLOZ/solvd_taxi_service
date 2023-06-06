package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.User;

public interface IUserDAO extends IDAO<User>{

        public User getUserByEmail(String email);

}
