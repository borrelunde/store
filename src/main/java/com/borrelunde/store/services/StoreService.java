package com.borrelunde.store.services;

import com.borrelunde.store.entities.Category;
import com.borrelunde.store.entities.Product;
import com.borrelunde.store.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@AllArgsConstructor
@Service
public class StoreService {

	private final ProductRepository productRepository;

	public void createNewProductAndAssignToCategory() {
		Category category = Category.builder()
				.name("Fruit")
				.build();

		Product product = Product.builder()
				.name("Banana")
				.description("Healthy and tasty")
				.price(BigDecimal.valueOf(4.99))
				.category(category)
				.build();

		productRepository.save(product);
	}
}
