package com.solvd.taxiservice.db.behavioral;

import com.solvd.taxiservice.db.model.RideType;

public abstract class Observer {

    protected RideType ridetype;
    public abstract void update();
}
