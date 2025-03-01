package com.borrelunde.store;

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

	public void placeOrder() {
		paymentService.processPayment(10.0);
	}
}
