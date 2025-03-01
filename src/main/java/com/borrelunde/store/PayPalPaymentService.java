package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class PayPalPaymentService implements PaymentService {

	@Override
	public void processPayment(final double amount) {
		System.out.printf("Processing payment of %.2f using PayPal.%n", amount);
	}
}
