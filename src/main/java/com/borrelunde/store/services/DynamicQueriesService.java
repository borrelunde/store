package com.borrelunde.store.services;

import com.borrelunde.store.entities.Product;
import com.borrelunde.store.repositories.ProductRepository;
import com.borrelunde.store.repositories.specifications.ProductSpecification;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

	public void printProductsByCriteriaUsingSpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice, String category) {
		Specification<Product> specification = Specification.where(null);
		if (name != null) {
			specification = specification.and(ProductSpecification.hasName(name));
		}
		if (minPrice != null) {
			specification = specification.and(ProductSpecification.hasPriceGreaterThanOrEqualTo(minPrice));
		}
		if (maxPrice != null) {
			specification = specification.and(ProductSpecification.hasPriceLessThanOrEqualTo(maxPrice));
		}
		if (category != null) {
			specification = specification.and(ProductSpecification.hasCategoryName(category));
		}
		List<Product> products = productRepository.findAll(specification);
		products.forEach(product -> {
			System.out.printf("Product: %s%n", product);
		});
	}
}
