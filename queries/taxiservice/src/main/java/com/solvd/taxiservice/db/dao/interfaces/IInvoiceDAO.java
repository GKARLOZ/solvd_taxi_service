package com.solvd.taxiservice.db.dao.interfaces;

import com.solvd.taxiservice.db.dao.interfaces.IDAO;
import com.solvd.taxiservice.db.model.Invoice;

public interface IInvoiceDAO extends IDAO<Invoice> {

    public Invoice getInvoiceByPaymentId(long id);


}
