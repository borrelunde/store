package com.borrelunde.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// SpringApplication.run(StoreApplication.class, args);
		var orderService = new OrderService();
		// There is a problem, the order service requires a payment service to
		// be set before placing an order. If we don't set a payment service,
		// we will get a NullPointerException.
		orderService.setPaymentService(new PayPalPaymentService());
		orderService.placeOrder();
	}
}