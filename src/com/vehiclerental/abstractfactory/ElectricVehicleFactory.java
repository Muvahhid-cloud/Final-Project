package com.vehiclerental.abstractfactory;

import com.vehiclerental.factory.*;

public class ElectricVehicleFactory implements VehicleAbstractFactory {

    @Override
    public Vehicle createSedan() {
        return new Sedan("Electric Sedan", 120);
    }

    @Override
    public Vehicle createSportBike() {
        return new SportBike("Electric SportBike", 70);
    }

    @Override
    public Vehicle createCargoVan() {
        return new CargoVan("Electric CargoVan", 180);
    }
}
