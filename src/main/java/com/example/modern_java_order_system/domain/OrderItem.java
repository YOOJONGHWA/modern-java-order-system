package com.example.modern_java_order_system.domain;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class OrderItem {

    private String productName;
    private int quantity;
    private int price;
}
