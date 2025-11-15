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

        inventory.addVehicle(factory.createSedan());
        inventory.addVehicle(factory.createSportBike());
        inventory.addVehicle(factory.createCargoVan());

        while (true) {
            System.out.println("\n--- Vehicle Rental Service ---");
            System.out.println("1. View vehicles");
            System.out.println("2. Rent");
            System.out.println("3. Return");
            System.out.println("4. Subscribe");
            System.out.println("5. Exit");
            System.out.print("Option: ");

            int opt = sc.nextInt();
            sc.nextLine();

            switch (opt) {
                case 1:
                    service.listVehicles();
                    break;

                case 2:
                    System.out.print("Your name: ");
                    String renter = sc.nextLine();

                    System.out.print("Enter vehicle name: ");
                    String name = sc.nextLine();

                    System.out.print("Pricing (1 Hourly, 2 Daily): ");
                    int p = sc.nextInt();
                    sc.nextLine();

                    PricingStrategy ps = (p == 1) ? new HourlyPricing() : new DailyPricing();

                    System.out.print("GPS? (y/n): ");
                    boolean gps = sc.nextLine().equalsIgnoreCase("y");

                    System.out.print("Insurance? (y/n): ");
                    boolean ins = sc.nextLine().equalsIgnoreCase("y");

                    service.rentVehicle(name, renter, ps, gps, ins);
                    break;

                case 3:
                    System.out.print("Your name: ");
                    String rn = sc.nextLine();

                    System.out.print("Vehicle name: ");
                    String vn = sc.nextLine();

                    service.returnVehicle(vn, rn);
                    break;

                case 4:
                    System.out.print("Enter your name: ");
                    String n = sc.nextLine();
                    service.subscribe(new Customer(n));
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid.");
            }
        }
    }
}
