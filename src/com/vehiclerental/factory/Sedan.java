package com.vehiclerental.factory;

public class Sedan extends Vehicle {
    public Sedan(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public String getType() {
        return "Sedan";
    }
}
