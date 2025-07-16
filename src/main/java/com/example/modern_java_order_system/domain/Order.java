package com.example.modern_java_order_system.domain;

import lombok.Data;

@Data
public class Order {

    private int id;

    private String productName;

    private int price;

    private int amount;

    public Order(int id, String productName, int price, int amount) {
        this.id = id;
        this.productName = productName;
        this.price = price;
        this.amount = amount;
    }

}
