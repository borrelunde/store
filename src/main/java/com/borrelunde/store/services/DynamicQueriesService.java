package com.borrelunde.store.services;

import com.borrelunde.store.entities.Product;
import com.borrelunde.store.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author B. Lunde
 * @since 2025.03.06
 */
@Service
public class DynamicQueriesService {

	private final ProductRepository productRepository;

	public DynamicQueriesService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public void printProductsByCriteria() {
		List<Product> products = productRepository.findProductsByCriteria(null, null, null, "fruit");
		products.forEach(product -> {
			System.out.printf("Product: %s%n", product);
		});
	}
}
