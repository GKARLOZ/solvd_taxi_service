package com.solvd.taxiservice.db.model;

import com.solvd.taxiservice.db.behavioral.Observer;

import java.util.ArrayList;
import java.util.List;

public class RideType{

    private long id;
    private String type;
    private double costPerMile;
    private List<Observer> observers = new ArrayList<>();

    public RideType(){};

    public RideType( String type, double costPerMile) {

        this.type = type;
        this.costPerMile = costPerMile;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getCostPerMile() {
        return costPerMile;
    }

    public void setCostPerMile(double costPerMile) {
        this.costPerMile = costPerMile;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }

    @Override
    public String toString() {
        return "RideType{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", costPerMile=" + costPerMile +
                '}';
    }


}
