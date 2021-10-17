package com.saproject.orderservice.controller;

import com.saproject.orderservice.pojo.Order;
import com.saproject.orderservice.util.DistanceCalculator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping(value = "/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping()
    public void placeOrder(@RequestBody Order order) {
            logger.info(order.toString());
        double distance = DistanceCalculator.distance(
                order.getUser().getAddress().getLatitude(),
                order.getRestaurant().getAddress().getLatitude(),
                order.getUser().getAddress().getLongitude(),
                order.getRestaurant().getAddress().getLongitude()
                );
        logger.info(String.valueOf(distance));
    }
}
