package com.example.modern_java_order_system.service;

import com.example.modern_java_order_system.domain.Order;
import com.example.modern_java_order_system.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public String order() {
        Order order = new Order(1, "Pen", 1000, 4);
        return repository.order(order);
    }
}
