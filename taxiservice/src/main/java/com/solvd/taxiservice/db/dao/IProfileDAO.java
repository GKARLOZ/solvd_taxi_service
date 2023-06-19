package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Profile;

public interface IProfileDAO extends IDAO<Profile> {

    public Profile getProfileByUserId(long id);
    public Profile getProfileByName(String Name);

    public Profile createAndGet(Profile profile);
}
