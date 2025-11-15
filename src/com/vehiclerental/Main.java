package com.vehiclerental;

import com.vehiclerental.abstractfactory.*;
import com.vehiclerental.data.VehicleInventory;
import com.vehiclerental.facade.RentalServiceFacade;
import com.vehiclerental.factory.Vehicle;
import com.vehiclerental.observer.Customer;
import com.vehiclerental.observer.VehicleAvailabilityNotifier;
import com.vehiclerental.strategy.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleAbstractFactory factory = new PetrolVehicleFactory();
        VehicleInventory inventory = new VehicleInventory();
        VehicleAvailabilityNotifier notifier = new VehicleAvailabilityNotifier();
        RentalServiceFacade service = new RentalServiceFacade(inventory, notifier);

        Vehicle v1 = factory.createSedan();
        Vehicle v2 = factory.createSportBike();
        Vehicle v3 = factory.createCargoVan();

        inventory.addVehicle(v1);
        inventory.addVehicle(v2);
        inventory.addVehicle(v3);

        while (true) {
            System.out.println("\n--- Vehicle Rental Service ---");
            System.out.println("1. View available vehicles");
            System.out.println("2. Rent a vehicle");
            System.out.println("3. Return a vehicle");
            System.out.println("4. Subscribe for notifications");
            System.out.println("5. Exit");
            System.out.print("Enter option: ");

            int opt = -1;
            if (sc.hasNextInt()) {
                opt = sc.nextInt();
            } else {
                sc.next(); // consume non-int
            }
            sc.nextLine();

            switch (opt) {
                case 1:
                    service.listVehicles();
                    break;

                case 2:
                    System.out.print("Enter vehicle name: ");
                    String name = sc.nextLine();

                    System.out.println("1. Hourly 2. Daily");
                    int p = -1;
                    if (sc.hasNextInt()) {
                        p = sc.nextInt();
                    } else {
                        sc.next();
                    }
                    sc.nextLine();

                    PricingStrategy ps = (p == 1) ? new HourlyPricing() : new DailyPricing();

                    System.out.print("GPS? (y/n): ");
                    boolean gps = sc.nextLine().trim().equalsIgnoreCase("y");

                    System.out.print("Insurance? (y/n): ");
                    boolean ins = sc.nextLine().trim().equalsIgnoreCase("y");

                    service.rentVehicle(name, ps, gps, ins);
                    break;

                case 3:
                    System.out.print("Enter vehicle name: ");
                    String r = sc.nextLine();
                    service.returnVehicle(r);
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String n = sc.nextLine();
                    service.subscribe(new Customer(n));
                    break;

                case 5:
                    System.out.println("Goodbye.");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
