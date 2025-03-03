package com.borrelunde.store;

import com.borrelunde.store.services.CustomQueriesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		CustomQueriesService customQueriesService = context.getBean(CustomQueriesService.class);

		// customQueriesService.populateDatabaseWithUsersAndProfilesWithLoyaltyPoints();
		customQueriesService.printLoyalUsers();
	}
}