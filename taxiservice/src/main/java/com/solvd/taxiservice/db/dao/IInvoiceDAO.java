package com.solvd.taxiservice.db.dao;

import com.solvd.taxiservice.db.model.Invoice;

public interface IInvoiceDAO extends IDAO<Invoice> {

    public Invoice getInvoiceByPaymentId(long id);


}
