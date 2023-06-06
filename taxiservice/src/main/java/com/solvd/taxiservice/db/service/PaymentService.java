package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.dao.IDAO;
import com.solvd.taxiservice.db.dao.IInvoiceDAO;
import com.solvd.taxiservice.db.dao.IPaymentMethodDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Payment;
import com.solvd.taxiservice.db.model.PaymentMethod;
import com.solvd.taxiservice.db.mysql.InvoiceDAO;
import com.solvd.taxiservice.db.mysql.PaymentDAO;
import com.solvd.taxiservice.db.mysql.PaymentMethodDAO;

public class PaymentService {

    PaymentDAO paymentDAO = new PaymentDAO();
    IPaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
    IInvoiceDAO invoiceDAO = new InvoiceDAO();
    InvoiceService invoiceService = new InvoiceService();

    public Payment getPaymentById(long id){

        Payment payment = paymentDAO.getById(id);
        PaymentMethod pm = paymentMethodDAO.getPMByPaymentId(id);
        Invoice invoice = invoiceService.getInvoiceById(invoiceDAO.getInvoiceByPaymentId(id).getId());

        payment.setPaymentMethod(pm);
        payment.setInvoice(invoice);

        return payment;

    }


}
