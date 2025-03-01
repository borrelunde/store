package com.borrelunde.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class OrderService {

	private final PaymentService paymentService;

	public OrderService(final PaymentService paymentService) {
		this.paymentService = paymentService;
		System.out.println("OrderService created");
	}

	@PostConstruct
	public void init() {
		System.out.println("OrderService post construct");
	}

	@PreDestroy
	public void cleanup() {
		System.out.println("OrderService cleanup");
	}

	public void placeOrder() {
		paymentService.processPayment(10.0);
	}
}
