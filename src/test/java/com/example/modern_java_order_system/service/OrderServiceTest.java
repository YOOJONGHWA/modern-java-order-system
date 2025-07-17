package com.example.modern_java_order_system.service;

import com.example.modern_java_order_system.domain.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    @DisplayName("주문 테스트")
    void 주문_테스트() {

        String result = orderService.createOrder();

        assertEquals("ok",result);
    }

    @Test
    @DisplayName("비싼 금액")
    void 비싼주문_테스트() {

        List<Order> result = orderService.findExpensiveOrders(5000);

        result.forEach(order -> {
            System.out.println("고객명: " + order.getCustomerName());
            System.out.println("총액: " + orderService.calculateOrderTotal(order));
        });

        assertFalse(result.isEmpty(), "비싼 주문이 존재해야 합니다");
    }
}