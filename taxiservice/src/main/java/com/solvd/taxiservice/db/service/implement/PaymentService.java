package com.solvd.taxiservice.db.service.implement;

import com.solvd.taxiservice.db.dao.interfaces.IInvoiceDAO;
import com.solvd.taxiservice.db.dao.interfaces.IPaymentMethodDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Payment;
import com.solvd.taxiservice.db.model.PaymentMethod;
import com.solvd.taxiservice.db.dao.mysql.InvoiceDAO;
import com.solvd.taxiservice.db.dao.mysql.PaymentDAO;
import com.solvd.taxiservice.db.dao.mysql.PaymentMethodDAO;

public class PaymentService {

    private PaymentDAO paymentDAO = new PaymentDAO();
    private IPaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
    private IInvoiceDAO invoiceDAO = new InvoiceDAO();
    private InvoiceService invoiceService = new InvoiceService();

    public Payment getPaymentById(long id){

        Payment payment = paymentDAO.getById(id);
        PaymentMethod pm = paymentMethodDAO.getPMByPaymentId(id);
        Invoice invoice = invoiceService.getInvoiceById(invoiceDAO.getInvoiceByPaymentId(id).getId());

        payment.setPaymentMethod(pm);
        payment.setInvoice(invoice);

        return payment;

    }


}
