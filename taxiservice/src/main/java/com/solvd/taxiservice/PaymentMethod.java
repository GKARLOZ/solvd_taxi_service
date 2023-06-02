package com.solvd.taxiservice;

public class PaymentMethod {

    private String method;
    private boolean asDefault;

    public PaymentMethod(){};

    public PaymentMethod(String method, boolean asDefault) {
        this.method = method;
        this.asDefault = asDefault;
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
