package com.borrelunde.store.repositories.specifications;

import com.borrelunde.store.entities.Product;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

/**
 * @author B. Lunde
 * @since 2025.03.06
 */
public class ProductSpecification {

	public static Specification<Product> hasName(String name) {
		return (root, query, cb) -> cb.like(root.get("name"), "%" + name + "%");
	}

	public static Specification<Product> hasPriceGreaterThanOrEqualTo(BigDecimal price) {
		return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), price);
	}

	public static Specification<Product> hasPriceLessThanOrEqualTo(BigDecimal price) {
		return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), price);
	}
}
