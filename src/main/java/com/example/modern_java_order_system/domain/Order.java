package com.example.modern_java_order_system.domain;

import com.example.modern_java_order_system.status.OrderStatus;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class Order {

    private int id;
    private List<OrderItem> items;
    private OrderStatus status;
    private LocalDateTime orderDate;
    private String customerName;
    private int totalPrice;

}
