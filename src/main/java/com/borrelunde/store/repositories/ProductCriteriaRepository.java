package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author B. Lunde
 * @since 2025.03.06
 */
public interface ProductCriteriaRepository {
	List<Product> findProductsByCriteria(String name, BigDecimal minPrice, BigDecimal maxPrice);
}
