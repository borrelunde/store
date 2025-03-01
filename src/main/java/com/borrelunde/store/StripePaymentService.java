package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class StripePaymentService implements PaymentService {

	@Override
	public void processPayment(double amount) {
		System.out.printf("Processing payment of %.2f using Stripe.%n", amount);
	}
}
