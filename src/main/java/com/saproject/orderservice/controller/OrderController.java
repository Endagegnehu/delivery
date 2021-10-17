package com.saproject.orderservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.saproject.orderservice.pojo.Order;
import com.saproject.orderservice.pojo.Payment;
import com.saproject.orderservice.pojo.User;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.DataInput;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping(value = "/order")
public class OrderController {
    Logger logger = LoggerFactory.getLogger(OrderController.class);
    @PostMapping()
    public void placeOrder(@RequestBody Order order) {
            logger.info(order.toString());
    }
}
