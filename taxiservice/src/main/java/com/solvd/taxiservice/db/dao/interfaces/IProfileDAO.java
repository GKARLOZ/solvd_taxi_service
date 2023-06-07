package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Profile;

public interface IProfileDAO extends IDAO<Profile> {

    public Profile getProfileByUserId(long id);
    public Profile getProfileByName(String Name);

    public Profile createProfile(Profile profile);
}
