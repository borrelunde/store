package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class OrderService {

	private PaymentService paymentService;

	public void placeOrder() {
		paymentService.processPayment(10.0);
	}

	public void setPaymentService(final PaymentService paymentService) {
		this.paymentService = paymentService;
	}
}
