package com.vehiclerental.factory;

public class SportBike extends Vehicle {
    public SportBike(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public String getType() {
        return "SportBike";
    }
}
