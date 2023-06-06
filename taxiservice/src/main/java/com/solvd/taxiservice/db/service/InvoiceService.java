package com.solvd.taxiservice.db.service;

import com.solvd.taxiservice.db.dao.IInvoiceDAO;
import com.solvd.taxiservice.db.dao.ITripDAO;
import com.solvd.taxiservice.db.model.Invoice;
import com.solvd.taxiservice.db.model.Trip;
import com.solvd.taxiservice.db.mysql.InvoiceDAO;
import com.solvd.taxiservice.db.mysql.TripDAO;

public class InvoiceService {

    IInvoiceDAO invoiceDAO = new InvoiceDAO();
    ITripDAO tripDAO = new TripDAO();
    TripService tripService = new TripService();

    public Invoice getInvoiceById(long id){

        Invoice invoice = invoiceDAO.getById(id);
        Trip trip = tripService.getTripById(tripDAO.getTripByInvoiceId(id).getId());
        invoice.setTrip(trip);

        return invoice;


    }


}
