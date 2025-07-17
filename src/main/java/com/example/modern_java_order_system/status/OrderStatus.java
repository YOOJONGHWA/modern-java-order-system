package com.example.modern_java_order_system.status;

import lombok.Getter;

@Getter
public enum OrderStatus {
    CREATED, PAID, SHIPPED, CANCELLED
}
