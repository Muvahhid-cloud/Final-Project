package com.vehiclerental.abstractfactory;

import com.vehiclerental.factory.*;

public class PetrolVehicleFactory implements VehicleAbstractFactory {

    @Override
    public Vehicle createSedan() {
        return new Sedan("Sedan", 80, "Petrol");
    }

    @Override
    public Vehicle createSportBike() {
        return new Sedan("Cobalt", 70, "Petrol");
    }

    @Override
    public Vehicle createCargoVan() {
        return new Sedan("Lexux", 150, "Petrol");
    }
}