package com.vehiclerental.factory;

public abstract class Vehicle {
    protected String name;
    protected double basePrice;
    protected boolean rented = false;

    public Vehicle(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }

    public boolean isRented() { return rented; }
    public void setRented(boolean r) { rented = r; }

    public abstract String getType();
}
