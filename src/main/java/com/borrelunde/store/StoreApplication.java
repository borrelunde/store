package com.borrelunde.store;

import com.borrelunde.store.services.DynamicQueriesService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		DynamicQueriesService service = context.getBean(DynamicQueriesService.class);

		service.printProductsByCriteria();
	}
}