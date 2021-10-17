package com.saproject.orderservice.pojo;

import lombok.Data;

@Data
public class Restaurant {
    private String id;
    private String restaurantName;
    private Address address;
}
