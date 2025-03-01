package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Configuration
public class AppConfig {

	@Value("${payment-method:stripe}")
	private String paymentMethod;

	@Bean
	public PaymentService stripe() {
		return new StripePaymentService();
	}

	@Bean
	public PaymentService paypal() {
		return new PayPalPaymentService();
	}

	@Bean
	@Scope("prototype")
	public OrderService orderService() {
		return new OrderService(getPaymentService());
	}

	@SuppressWarnings("SwitchStatementWithTooFewBranches")
	private PaymentService getPaymentService() {
		return switch (paymentMethod) {
			case "paypal" -> paypal();
			default -> stripe();
		};
	}
}
