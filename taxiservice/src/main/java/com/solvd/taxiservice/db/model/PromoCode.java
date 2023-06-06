package com.solvd.taxiservice.db.model;

import java.util.Date;

public class PromoCode {

    private long id;
    private String code;
    private double discount;
    private Date expirationDate;

    public PromoCode(){};

    public PromoCode( String code, double discount, Date expirationDate) {

        this.code = code;
        this.discount = discount;
        this.expirationDate = expirationDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public String toString() {
        return "PromoCode{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", discount=" + discount +
                ", expirationDate=" + expirationDate +
                '}';
    }
}
