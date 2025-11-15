package com.vehiclerental.factory;

public class Sedan extends Vehicle {
    public Sedan(String name, double basePrice, String fuelType) {
        super(name, basePrice, fuelType);
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}