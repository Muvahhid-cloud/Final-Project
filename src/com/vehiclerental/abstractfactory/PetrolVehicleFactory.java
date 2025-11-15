package com.vehiclerental.abstractfactory;

import com.vehiclerental.factory.*;

public class PetrolVehicleFactory implements VehicleAbstractFactory {

    @Override
    public Vehicle createSedan() {
        return new Sedan("Petrol Sedan", 80);
    }

    @Override
    public Vehicle createSportBike() {
        return new SportBike("Petrol SportBike", 50);
    }

    @Override
    public Vehicle createCargoVan() {
        return new CargoVan("Petrol CargoVan", 110);
    }
}
