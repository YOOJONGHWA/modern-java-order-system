package com.example.modern_java_order_system;

import com.example.modern_java_order_system.domain.Order;
import com.example.modern_java_order_system.service.OrderService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModernJavaOrderSystemApplication implements CommandLineRunner {

	private final OrderService orderService;

	public ModernJavaOrderSystemApplication(OrderService orderService) {
		this.orderService = orderService;
	}

	public static void main(String[] args) {
		SpringApplication.run(ModernJavaOrderSystemApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Order order = new Order(1, "Pen", 1000, 4);
		String result = orderService.order();
		System.out.println("주문 결과: " + result);
	}
}
