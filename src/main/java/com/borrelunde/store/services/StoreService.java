package com.borrelunde.store.services;

import com.borrelunde.store.entities.Category;
import com.borrelunde.store.repositories.CategoryRepository;
import com.borrelunde.store.entities.Product;
import com.borrelunde.store.repositories.ProductRepository;
import jakarta.transaction.Transactional;
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
	private final CategoryRepository categoryRepository;

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

	@Transactional
	public void fetchCategoryAndCreateNewProduct() {
		Category category = categoryRepository.findById((byte) 1).orElseThrow();

		Product product = Product.builder()
				.name("Apple")
				.description("Keeps the doctor away")
				.price(BigDecimal.valueOf(2.99))
				.category(category)
				.build();

		productRepository.save(product);
	}
}
