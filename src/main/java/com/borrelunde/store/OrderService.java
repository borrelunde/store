package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Service
public class OrderService {

	private final PaymentService paymentService;

	public OrderService(@Qualifier("stripe") final PaymentService paymentService) {
		this.paymentService = paymentService;
	}

	public void placeOrder() {
		paymentService.processPayment(10.0);
	}
}
