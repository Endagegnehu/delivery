package com.saproject.orderservice.controller;

import com.saproject.orderservice.pojo.Food;
import com.saproject.orderservice.pojo.Order;
import com.saproject.orderservice.util.DistanceCalculator;
import com.saproject.orderservice.util.TotalPriceCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController()
@RequestMapping(value = "/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    Map<String, Double> payment = new HashMap<>();
    @PostMapping()
    public void placeOrder(@RequestBody Order order) {
            logger.info(order.toString());
       double allPrice = 0.0;
        for (int i = 0; i < order.getFoods().size(); i++) {
            allPrice = allPrice + order.getFoods().get(i).getPrice();
        }
        double distance = DistanceCalculator.distance(
                order.getUser().getAddress().getLatitude(),
                order.getRestaurant().getAddress().getLatitude(),
                order.getUser().getAddress().getLongitude(),
                order.getRestaurant().getAddress().getLongitude()
                );
        payment = TotalPriceCalculator.calculateTotalPriceAndTax(distance,allPrice);
        logger.info(String.valueOf(payment));
    }
    @GetMapping("/getPrice")
    public Map<String, Double> getTotalPrice(){
        return payment.isEmpty()?null:payment;
    }
}
