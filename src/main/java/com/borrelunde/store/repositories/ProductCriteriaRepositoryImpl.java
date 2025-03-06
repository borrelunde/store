package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Category;
import com.borrelunde.store.entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author B. Lunde
 * @since 2025.03.06
 */
@AllArgsConstructor
@Repository
public class ProductCriteriaRepositoryImpl implements ProductCriteriaRepository {

	@PersistenceContext
	private final EntityManager entityManager;

	@Override
	public List<Product> findProductsByCriteria(final String name, final BigDecimal minPrice, final BigDecimal maxPrice, String category) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<Product> query = builder.createQuery(Product.class);
		Root<Product> root = query.from(Product.class);

		List<Predicate> predicates = new ArrayList<>();
		if (name != null) {
			// name like name
			predicates.add(builder.like(root.get("name"), "%" + name + "%"));
		}
		if (minPrice != null) {
			// price >= minPrice
			predicates.add(builder.greaterThanOrEqualTo(root.get("price"), minPrice));
		}
		if (maxPrice != null) {
			// price <= maxPrice
			predicates.add(builder.lessThanOrEqualTo(root.get("price"), maxPrice));
		}
		if (category != null) {
			Join<Product, Category> categoryJoin = root.join("category");
			// category like %category%
			predicates.add(builder.like(categoryJoin.get("name"), "%" + category + "%"));
		}
		query.select(root).where(predicates.toArray(new Predicate[0]));

		return entityManager.createQuery(query).getResultList();
	}
}
