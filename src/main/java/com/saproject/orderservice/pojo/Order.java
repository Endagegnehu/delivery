package com.saproject.orderservice.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Order {
    private User user;
    private List<Food> order;
    private Restaurant restaurant;
    private Payment payment;
}
