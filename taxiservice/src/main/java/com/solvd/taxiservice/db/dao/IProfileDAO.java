package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Profile;

public interface IProfileDAO extends IDAO<Profile>{

    public Profile getProfileByUserId(int id);
    public Profile getProfileByName(String Name);
}
