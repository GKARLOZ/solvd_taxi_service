package com.solvd.taxiservice;

public class Payment {

        private String paymentStatus;
        private PaymentMethod paymentMethod;
        private Invoice invoice;

        public Payment(){};

    public Payment(String paymentStatus, PaymentMethod paymentMethod, Invoice invoice) {
        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.invoice = invoice;
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
