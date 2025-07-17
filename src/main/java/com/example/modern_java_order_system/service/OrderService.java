package com.example.modern_java_order_system.service;

import com.example.modern_java_order_system.domain.Order;
import com.example.modern_java_order_system.domain.OrderItem;
import com.example.modern_java_order_system.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.example.modern_java_order_system.status.OrderStatus.CREATED;
import static java.time.LocalDateTime.now;

@Service
@AllArgsConstructor
public class OrderService {

    public final OrderRepository repository;

    public String createOrder() {

        OrderItem paper = OrderItem.builder()
                .productName("paper")
                .price(1000)
                .quantity(5)
                .build();

        List<OrderItem> items = new ArrayList<>();
        items.add(paper);

        Order order = Order.builder()
                .id(1)
                .items(items)
                .status(CREATED)
                .orderDate(now())
                .customerName("test")
                .build();

        return repository.createOrder(order);
    }

    // not use stream
    public void printAllOrders() {
        for (Order order : repository.orders) {
            System.out.println("고객명: " + order.getCustomerName());
            for (OrderItem item : order.getItems()) {
                System.out.println(" - " + item.getProductName()
                        + " x " + item.getQuantity()
                        + " (" + item.getPrice() * item.getQuantity() + "원)");
            }
            System.out.println("주문 상태: " + order.getStatus());
            System.out.println("-----------");
        }
    }
    
    public int calculateOrderTotal(Order order) {
        return  order.getItems().stream()
                .mapToInt(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public List<Order> findExpensiveOrders(int threshold) {
        return repository.orders.stream()
                .filter(order -> calculateOrderTotal(order) >= threshold)
                .collect(Collectors.toList());
    }
    
    public Map<String, List<Order>> groupOrdersByCustomer() {
        return repository.orders.stream()
                .collect(Collectors.groupingBy(Order::getCustomerName));
    }
    
}
