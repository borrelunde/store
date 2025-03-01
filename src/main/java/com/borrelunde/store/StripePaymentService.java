package com.borrelunde.store;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Service("stripe")
@Primary
public class StripePaymentService implements PaymentService {

	@Override
	public void processPayment(double amount) {
		System.out.printf("Processing payment of %.2f using Stripe.%n", amount);
	}
}
