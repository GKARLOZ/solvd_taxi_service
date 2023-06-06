package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.PaymentMethod;

public interface IPaymentMethodDAO extends IDAO<PaymentMethod>{

    public PaymentMethod getPMByPaymentId(long id);
}
