package com.saproject.orderservice.pojo;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class Order {
    private Long id;
    private User user;
    private List<Food> foods;
    private Restaurant restaurant;
    private Payment payment;
    private Dasher dasher;
}
