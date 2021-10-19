package com.saproject.orderservice.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class PaymentToDo {
    private Order order;
    private Map<String, Long> paymentToMake;
}
