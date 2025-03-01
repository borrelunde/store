package com.borrelunde.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var orderService = context.getBean(OrderService.class);
		orderService.placeOrder();

		var userService = context.getBean(UserService.class);
		final User john = new User(
				0,
				"john.doe@mail.com",
				"johndoe123",
				"John Doe"
		);
		userService.registerUser(john);
		userService.registerUser(john);

		context.close();
	}
}