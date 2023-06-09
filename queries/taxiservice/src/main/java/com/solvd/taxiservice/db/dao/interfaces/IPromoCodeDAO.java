package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.PromoCode;

public interface IPromoCodeDAO extends IDAO<PromoCode> {

    public PromoCode getPromoCodeByTripId(long id);
}
