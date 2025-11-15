package com.vehiclerental.strategy;

public class HourlyPricing implements PricingStrategy {
    @Override
    public double calculate(double basePrice, int hours) {
        return basePrice * 1.2 * hours;
    }
}