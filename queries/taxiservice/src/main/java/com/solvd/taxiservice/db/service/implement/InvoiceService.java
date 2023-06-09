package com.solvd.taxiservice.db.service.implement;

import com.solvd.taxiservice.db.dao.interfaces.IInvoiceDAO;
import com.solvd.taxiservice.db.dao.interfaces.ITripDAO;
import com.solvd.taxiservice.db.dao.mysql.PaymentDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.dao.mysql.InvoiceDAO;
import com.solvd.taxiservice.db.dao.mysql.TripDAO;
import com.solvd.taxiservice.db.service.interfaces.IService;

public class InvoiceService implements IService<Invoice> {

    private IInvoiceDAO invoiceDAO = new InvoiceDAO();
    private ITripDAO tripDAO = new TripDAO();
    private TripService tripService = new TripService();
    private PaymentDAO paymentDAO = new PaymentDAO();

    @Override
    public void create(Invoice invoice) {

    }

    @Override
    public Invoice getById(long id) {

        Invoice invoice = invoiceDAO.getById(id);
        Trip trip = tripService.getTripById(tripDAO.getTripByInvoiceId(id).getId());
        invoice.setTrip(trip);

        return invoice;
    }

    @Override
    public void update(Invoice invoice) {

        invoiceDAO.update(invoice);

    }

    @Override
    public void delete(Invoice invoice) {
        invoiceDAO.delete(invoice);
    }
}
