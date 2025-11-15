package com.vehiclerental.strategy;

public class HourlyPricing implements PricingStrategy {
    @Override
    public double calculate(double basePrice) {
        return basePrice * 1.2;
    }
}
