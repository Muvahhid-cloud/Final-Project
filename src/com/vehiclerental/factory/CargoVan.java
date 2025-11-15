package com.vehiclerental.factory;

public class CargoVan extends Vehicle {
    public CargoVan(String name, double basePrice, String fuelType) {
        super(name, basePrice, fuelType);
    }

    @Override
    public String getType() {
        return "CargoVan";
    }
}