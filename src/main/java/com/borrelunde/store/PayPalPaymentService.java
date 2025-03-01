package com.borrelunde.store;

import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Service("paypal")
public class PayPalPaymentService implements PaymentService {

	@Override
	public void processPayment(final double amount) {
		System.out.printf("Processing payment of %.2f using PayPal.%n", amount);
	}
}
