package com.vehiclerental.decorator;

import com.vehiclerental.factory.Vehicle;

public class GPSDecorator extends VehicleDecorator {

    public GPSDecorator(Vehicle v) {
        super(v);
    }

    @Override
    public double getBasePrice() {
        return wrapped.getBasePrice() + 15;
    }

    @Override
    public String getType() {
        return wrapped.getType() + " + GPS";
    }
}
