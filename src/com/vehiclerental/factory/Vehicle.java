package com.vehiclerental.factory;

public abstract class Vehicle {
    protected String name;
    protected double basePrice;
    protected boolean rented = false;
    protected String rentedBy = null;

    public Vehicle(String name, double basePrice) {
        this.name = name;
        this.basePrice = basePrice;
    }

    public String getName() { return name; }
    public double getBasePrice() { return basePrice; }

    public boolean isRented() { return rented; }
    public void setRented(boolean r) { rented = r; }

    public String getRentedBy() { return rentedBy; }
    public void setRentedBy(String rentedBy) { this.rentedBy = rentedBy; }

    public abstract String getType();
}
