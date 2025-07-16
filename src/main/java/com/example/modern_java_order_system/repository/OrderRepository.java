package com.example.modern_java_order_system.repository;

import com.example.modern_java_order_system.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    public final List<Order> orders = new ArrayList<>();

    public String order(Order order) {
        orders.add(order);
        return "ok";
    }
}
