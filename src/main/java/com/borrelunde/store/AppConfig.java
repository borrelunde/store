package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

	@Bean
	public NotificationService email() {
		return new EmailNotificationService();
	}

	@Bean
	public UserRepository inMemoryUserRepository() {
		return new InMemoryUserRepository();
	}

	@Bean
	public UserService userService() {
		return new UserService(inMemoryUserRepository(), email());
	}
}
