package com.vehiclerental.abstractfactory;

import com.vehiclerental.factory.*;

public class ElectricVehicleFactory implements VehicleAbstractFactory {

    @Override
    public Vehicle createSedan() {
        return new Sedan("BYD", 120, "Electric");
    }

    @Override
    public Vehicle createSportBike() {
        return new Sedan("Chery", 110, "Electric");
    }

    @Override
    public Vehicle createCargoVan() {
        return new Sedan("Zeekr", 180, "Electric");
    }
}