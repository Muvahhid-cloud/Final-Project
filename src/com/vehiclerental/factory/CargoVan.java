package com.vehiclerental.factory;

public class CargoVan extends Vehicle {
    public CargoVan(String name, double basePrice) {
        super(name, basePrice);
    }

    @Override
    public String getType() {
        return "CargoVan";
    }
}
