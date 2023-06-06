package com.solvd.taxiservice.db.model;

public class PaymentMethod {

    private long id;
    private String method;
    private String comment;

    public PaymentMethod(){};

    public PaymentMethod(String method, String comment) {

        this.method = method;
        this.comment = comment;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String isComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "PaymentMethod{" +
                "id=" + id +
                ", method='" + method + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
