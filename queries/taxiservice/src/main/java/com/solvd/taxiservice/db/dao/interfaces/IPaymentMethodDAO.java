package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.PaymentMethod;

public interface IPaymentMethodDAO extends IDAO<PaymentMethod> {

    public PaymentMethod getPMByPaymentId(long id);
}
