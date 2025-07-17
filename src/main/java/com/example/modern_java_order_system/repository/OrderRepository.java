package com.example.modern_java_order_system.repository;

import com.example.modern_java_order_system.domain.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    public final List<Order> orders = new ArrayList<>();
    public int id = 1;

    public String createOrder(Order order) {
        order.setId(id++);
        orders.add(order);
        return "ok";
    }

    public List<Order> showInfo() {
        return orders;
    }
}
