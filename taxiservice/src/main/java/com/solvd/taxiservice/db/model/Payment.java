package com.solvd.taxiservice.db.model;

public class Payment {

        private String id;
        private String paymentStatus;
        private PaymentMethod paymentMethod;
        private Invoice invoice;

        public Payment(){};

    public Payment(String id, String paymentStatus, PaymentMethod paymentMethod, Invoice invoice) {
        this.id = id;
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.invoice = invoice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Invoice getInvoice() {
        return invoice;
    }

    public void setInvoice(Invoice invoice) {
        this.invoice = invoice;
    }
}
