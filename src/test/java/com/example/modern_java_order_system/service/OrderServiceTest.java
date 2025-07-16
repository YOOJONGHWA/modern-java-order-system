package com.example.modern_java_order_system.service;

import com.example.modern_java_order_system.domain.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderServiceTest {

    @Autowired
    OrderService orderService;

    @Test
    void 주문_정상_처리() {

        Order order = new Order(1, "Pen", 1000, 4);
        String result = orderService.order(order);
        assertEquals("ok",result);
    }
}