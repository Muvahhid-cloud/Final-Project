package com.vehiclerental.abstractfactory;

import com.vehiclerental.factory.Vehicle;

public interface VehicleAbstractFactory {
    Vehicle createSedan();
    Vehicle createSportBike();
    Vehicle createCargoVan();
}
