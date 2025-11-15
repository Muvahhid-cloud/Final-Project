package com.vehiclerental.facade;

import com.vehiclerental.data.VehicleInventory;
import com.vehiclerental.decorator.GPSDecorator;
import com.vehiclerental.decorator.InsuranceDecorator;
import com.vehiclerental.factory.Vehicle;
import com.vehiclerental.observer.Observer;
import com.vehiclerental.observer.VehicleAvailabilityNotifier;
import com.vehiclerental.strategy.PricingStrategy;

public class RentalServiceFacade {

    private VehicleInventory inventory;
    private VehicleAvailabilityNotifier notifier;

    public RentalServiceFacade(VehicleInventory inv, VehicleAvailabilityNotifier not) {
        this.inventory = inv;
        this.notifier = not;
    }

    public void listVehicles() {
        System.out.println("Available / Rented vehicles:");
        for (Vehicle v : inventory.getVehicles()) {
            System.out.println(v.getName() + " | " + v.getType()
                    + " | Rented: " + v.isRented()
                    + (v.isRented() ? " | By: " + v.getRentedBy() : ""));
        }
    }

    public void rentVehicle(String name, String renterName,
                            PricingStrategy strategy, boolean gps, boolean ins) {

        Vehicle v = inventory.findByName(name);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (v.isRented()) {
            System.out.println("❌ Vehicle already rented by " + v.getRentedBy());
            return;
        }

        Vehicle decorated = v;
        if (gps) decorated = new GPSDecorator(decorated);
        if (ins) decorated = new InsuranceDecorator(decorated);

        double cost = strategy.calculate(decorated.getBasePrice());

        v.setRented(true);
        v.setRentedBy(renterName);

        System.out.println("✅ Vehicle rented successfully!");
        System.out.println("Rented by: " + renterName);
        System.out.println("Total cost: " + cost);
    }

    public void returnVehicle(String name, String renterName) {
        Vehicle v = inventory.findByName(name);

        if (v == null) {
            System.out.println("Vehicle not found.");
            return;
        }

        if (!v.isRented()) {
            System.out.println("This vehicle is not rented.");
            return;
        }

        if (!v.getRentedBy().equals(renterName)) {
            System.out.println("❌ You cannot return this vehicle. It was rented by: "
                    + v.getRentedBy());
            return;
        }

        v.setRented(false);
        v.setRentedBy(null);

        System.out.println("✅ Vehicle returned!");

        notifier.notifySubscribers(name + " is now available.");
    }

    public void subscribe(Observer o) {
        notifier.subscribe(o);
        System.out.println("Subscribed!");
    }
}
