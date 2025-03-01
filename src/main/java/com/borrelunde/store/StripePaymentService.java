package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Value;

import java.util.List;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class StripePaymentService implements PaymentService {

	@Value("${stripe.apiUrl}")
	private String apiUrl;

	@Value("${stripe.enabled}")
	private boolean enabled;

	@Value("${stripe.timeout:3000}")
	private int timeout;

	@Value("${stripe.supported-currencies}")
	private List<String> supportedCurrencies;

	@Override
	public void processPayment(double amount) {
		System.out.printf("Stripe API URL: %s%n", apiUrl);
		System.out.printf("Stripe enabled: %b%n", enabled);
		System.out.printf("Stripe timeout: %d%n", timeout);
		System.out.printf("Stripe supported currencies: %s%n", supportedCurrencies);
		System.out.printf("Processing payment of %.2f using Stripe.%n", amount);
	}
}
