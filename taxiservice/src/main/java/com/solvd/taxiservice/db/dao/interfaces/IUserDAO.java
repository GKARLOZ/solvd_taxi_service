package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.User;

public interface IUserDAO extends IDAO<User> {

        public User getUserByEmail(String email);

}
