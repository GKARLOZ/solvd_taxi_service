package com.solvd.taxiservice.db.service.implement;

import com.solvd.taxiservice.db.dao.interfaces.IInvoiceDAO;
import com.solvd.taxiservice.db.dao.interfaces.ITripDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.dao.mysql.InvoiceDAO;
import com.solvd.taxiservice.db.dao.mysql.TripDAO;

public class InvoiceService {

    private IInvoiceDAO invoiceDAO = new InvoiceDAO();
    private ITripDAO tripDAO = new TripDAO();
    private TripService tripService = new TripService();

    public Invoice getInvoiceById(long id){

        Invoice invoice = invoiceDAO.getById(id);
        Trip trip = tripService.getTripById(tripDAO.getTripByInvoiceId(id).getId());
        invoice.setTrip(trip);

        return invoice;


    }


}
