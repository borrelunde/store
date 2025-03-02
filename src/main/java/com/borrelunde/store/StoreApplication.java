package com.borrelunde.store;

import com.borrelunde.store.entities.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var user = User.builder()
				.id(1L)
				.name("John")
				.email("john@gmail.com")
				.password("password")
				.build();
	}
}