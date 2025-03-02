package com.borrelunde.store;

import com.borrelunde.store.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.math.BigDecimal;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		// ApplicationContext context = SpringApplication.run(StoreApplication.class, args);

		var category = Category.builder()
				.id((byte) 1)
				.name("Furniture")
				.build();

		var productOne = Product.builder()
				.id(1L)
				.name("Desk")
				.price(BigDecimal.valueOf(249.99))
				.build();

		var productTwo = Product.builder()
				.id(2L)
				.name("Table")
				.price(BigDecimal.valueOf(439.99))
				.build();

		category.addProduct(productOne);
		category.addProduct(productTwo);

		System.out.printf("User: %s\n", category);
	}
}