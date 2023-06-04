package com.solvd.taxiservice.db.model;

public class PaymentMethod {

    private String id;
    private String method;
    private boolean asDefault;

    public PaymentMethod(){};

    public PaymentMethod(String id, String method, boolean asDefault) {
        this.id = id;
        this.method = method;
        this.asDefault = asDefault;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public boolean isAsDefault() {
        return asDefault;
    }

    public void setAsDefault(boolean asDefault) {
        this.asDefault = asDefault;
    }
}
