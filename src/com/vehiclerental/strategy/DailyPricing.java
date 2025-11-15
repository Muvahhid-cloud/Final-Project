package com.vehiclerental.strategy;

public class DailyPricing implements PricingStrategy {
    @Override
    public double calculate(double basePrice) {
        return basePrice * 5;
    }
}
