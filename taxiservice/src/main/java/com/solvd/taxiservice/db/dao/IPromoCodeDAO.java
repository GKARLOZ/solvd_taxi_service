package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.PromoCode;

public interface IPromoCodeDAO extends IDAO<PromoCode>{

    public PromoCode getPromoCodeByTripId(long id);
}
