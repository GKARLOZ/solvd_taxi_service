package com.solvd.taxiservice.db.model;

public class Payment {

        private long id;
        private String paymentStatus;
        private PaymentMethod paymentMethod;
        private Invoice invoice;

        public Payment(){
            this.invoice = new Invoice();
            this.paymentMethod = new PaymentMethod();
        };

    public Payment( String paymentStatus, PaymentMethod paymentMethod, Invoice invoice) {

        this.paymentStatus = paymentStatus;
        this.paymentMethod = paymentMethod;
        this.invoice = invoice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", paymentStatus='" + paymentStatus + '\'' +
                ", paymentMethod=" + paymentMethod +
                ", invoice=" + invoice +
                '}';
    }
}
