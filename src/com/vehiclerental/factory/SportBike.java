package com.vehiclerental.factory;

public class SportBike extends Vehicle {
    public SportBike(String name, double basePrice, String fuelType) {
        super(name, basePrice, fuelType);
    }

    @Override
    public String getType() {
        return "SportBike";
    }
}