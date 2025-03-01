package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class OrderService {

	private PaymentService paymentService;

	public OrderService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void placeOrder() {
		paymentService.processPayment(10.0);
	}
}
