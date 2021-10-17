package com.saproject.orderservice.util;

import java.util.HashMap;
import java.util.Map;

import static com.saproject.orderservice.util.Constants.*;

public class TotalPriceCalculator {

    public static Map<String,Double> calculateTotalPriceAndTax(double distance, double totalFoodPrice){
            Map<String, Double> totalPrice = new HashMap<>();
            double initialPrice = 3;
            double pricePreMail = 2.0;
            double totalTax = 0.0;

            double driverPrice = initialPrice + (pricePreMail * distance);
            totalFoodPrice -= driverPrice;
            double driverPriceTax = driverPrice * 0.01;
            driverPrice -= driverPriceTax;

            double restaurantTax = totalFoodPrice * 0.04;
            totalFoodPrice -= restaurantTax;

            double ourCompanyPayment = totalFoodPrice * 0.1;
            double ourCompanyPaymentTax = ourCompanyPayment * 0.02;
            totalFoodPrice -= ourCompanyPayment;


            totalTax = driverPriceTax + restaurantTax+ourCompanyPaymentTax;

            totalPrice.put(DRIVER_PRICE, driverPrice);
            totalPrice.put(TAX, totalTax);
            totalPrice.put(OUR_COMPANY_PAYMENT, ourCompanyPayment);
            totalPrice.put(RESTAURANT_PAYMENT, totalFoodPrice);

        return totalPrice;
    }
}
