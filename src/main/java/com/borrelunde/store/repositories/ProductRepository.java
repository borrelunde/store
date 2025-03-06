package com.borrelunde.store.repositories;

import com.borrelunde.store.dtos.ProductSummaryDto;
import com.borrelunde.store.entities.Category;
import com.borrelunde.store.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, ProductCriteriaRepository {

	// Strings
	List<Product> findByName(String name);  // select * from products where name = ?
	List<Product> findByNameLike(String name);
	List<Product> findByNameNotLike(String name);
	List<Product> findByNameContaining(String name);
	List<Product> findByNameStartingWith(String name);
	List<Product> findByNameEndingWith(String name);
	List<Product> findByNameEndingWithIgnoreCase(String name);

	// Numbers
	List<Product> findByPrice(BigDecimal price);  // select * from products where price = ?
	List<Product> findByPriceGreaterThan(BigDecimal price);
	List<Product> findByPriceGreaterThanEqual(BigDecimal price);
	List<Product> findByPriceLessThan(BigDecimal price);
	List<Product> findByPriceLessThanEqual(BigDecimal price);
	List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);

	// Null
	List<Product> findByDescriptionNull();
	List<Product> findByDescriptionNotNull();

	// Multiple conditions
	List<Product> findByDescriptionNullAndNameNull();

	// Sort (OrderBy)
	List<Product> findByNameOrderByPriceAsc(String name);
	List<Product> findByNameOrderByPriceDesc(String name);

	// Limit (Top/First)
	List<Product> findTop5ByNameOrderByPrice(String name);  // downside: 5 is hardcoded
	List<Product> findFirst5ByNameLikeOrderByPrice(String name);  // downside: 5 is hardcoded


	// Find products whose prices are in a given range and sort by name.

	// Using a derived query is possible like so:
	List<Product> findByPriceBetweenOrderByName(BigDecimal min, BigDecimal max);

	// But you can also use @Query to write your own query, in SQL or JPQL (Java
	// Persistent Query Language). You can extract a derived query method to a
	// JPQL Query method.

	// Using SQL:
	@Query(value = "select * from products p where p.price between :min and :max order by p.name", nativeQuery = true)
	List<Product> findProductsUsingSql(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	// Using JPQL:
	@Query("select p from Product p where p.price between :min and :max order by p.name")
	List<Product> findProductsUsingJpql(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	// Using JPQL (extracted from a derived query method):
	@Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
	List<Product> findProductsExtracted(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	@Query("select count(*) from Product p where p.price between :min and :max")
	long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

	// Use the modifying annotation when you update, not select.
	@Modifying
	@Query("update Product p set p.price = :newPrice where p.category.id = :categoryId")
	void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);


	// Projections lets you query the data you need and not more.

	// Recommended to use interface DTO, use class DTO when you need extra logic.
	// Here: ProductSummary (interface) vs. ProductSummaryDto (class).
	@Query("select new com.borrelunde.store.dtos.ProductSummaryDto(p.id, p.name) from Product p where p.category = :category")
	List<ProductSummaryDto> findByCategory(@Param("category") Category category);


	@Procedure("findProductsByPrice")
	List<Product> findProducts(BigDecimal min, BigDecimal max);
}