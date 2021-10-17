package com.saproject.orderservice.pojo;

import lombok.Data;

@Data
public class Payment {
    private String cardNumber;
    private String expireDate;
    private String ccv;
}
