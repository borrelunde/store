package com.borrelunde.store;

import com.borrelunde.store.entities.*;
import com.borrelunde.store.repositories.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		repository.save(User.builder()
				.name("John")
				.email("john@mail.com")
				.password("password")
				.build()
		);

		User user = repository.findById(1L).orElseThrow();
		System.out.printf("User email: %s\n", user.getEmail());

		repository.findAll().forEach(u -> {
			System.out.printf("User email: %s\n", u.getEmail());
		});

		repository.deleteById(1L);
	}
}