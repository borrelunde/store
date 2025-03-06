package com.borrelunde.store.services;

import com.borrelunde.store.entities.Category;
import com.borrelunde.store.entities.User;
import com.borrelunde.store.repositories.CategoryRepository;
import com.borrelunde.store.entities.Product;
import com.borrelunde.store.repositories.ProductRepository;
import com.borrelunde.store.repositories.UserRepository;
import com.borrelunde.store.repositories.specifications.ProductSpecification;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@AllArgsConstructor
@Service
public class StoreService {

	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	private final UserRepository userRepository;

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

	public void fetchExistingUserAndAddAllExistingProductsToWishlist() {
		User user = userRepository.findById(2L).orElseThrow();
		List<Product> allProducts = (List<Product>) productRepository.findAll();
		user.setWishlist(allProducts);
		userRepository.save(user);
	}

	public void deleteAnExistingProduct() {
		Product product = productRepository.findById(1L).orElseThrow();
		productRepository.delete(product);
	}

	@Transactional  // An updating query requires the transactional annotation.
	public void updateProductPrices() {
		productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte) 1);
	}

	public void fetchProducts() {
		var products = productRepository.findByCategory(new Category((byte) 1));
		products.forEach(System.out::println);
	}

	@Transactional
	public void fetchUser() {
		User user = userRepository.findByEmail("john@mail.com").orElseThrow();
		System.out.printf("User: %s\n", user);
	}

	@Transactional
	public void fetchUsers() {
		Iterable<User> users = userRepository.findAllWithAddresses();
		users.forEach(u -> {
			System.out.println(u);
			u.getAddresses().forEach(System.out::println);
		});
	}

	@Transactional
	public void fetchProductsUsingProcedure() {
		List<Product> products = productRepository.findProducts(BigDecimal.valueOf(1), BigDecimal.valueOf(15));
		products.forEach(System.out::println);
	}

	@Transactional
	public void prepareQueryByExample() {
		Category fruitCategory = Category.builder()
				.name("Fruit")
				.build();

		Product banana = Product.builder()
				.name("Banana")
				.description("Healthy and tasty")
				.price(BigDecimal.valueOf(4.99))
				.category(fruitCategory)
				.build();

		Product apple = Product.builder()
				.name("Apple")
				.description("Keeps the doctor away")
				.price(BigDecimal.valueOf(2.99))
				.category(fruitCategory)
				.build();

		productRepository.save(banana);
		productRepository.save(apple);
	}

	@Transactional
	public void fetchProductsUsingQueryByExample() {
		Product product = Product.builder()
				.name("bana")
				.build();

		ExampleMatcher matcher = ExampleMatcher.matching()
				.withIncludeNullValues()
				.withIgnorePaths("id", "description")
				.withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
		Example<Product> example = Example.of(product, matcher);

		List<Product> products = productRepository.findAll(example);
		products.forEach(System.out::println);
	}

	public void fetchProductsByCriteria() {
		List<Product> products = productRepository.findProductsByCriteria(
				null, BigDecimal.valueOf(1), BigDecimal.valueOf(3));
		products.forEach(System.out::println);
	}

	public void fetchProductsBySpecifications(String name, BigDecimal minPrice, BigDecimal maxPrice) {
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
		List<Product> products = productRepository.findAll(specification);
		products.forEach(System.out::println);
	}

	public void fetchSortedProducts() {
		Sort sort = Sort.by("name").and(
				Sort.by("price").descending()
		);
		List<Product> products = productRepository.findAll(sort);
		products.forEach(System.out::println);
	}

	public void fetchPaginatedProducts(int pageNumber, int size) {
		PageRequest pageRequest = PageRequest.of(pageNumber, size);
		Page<Product> page = productRepository.findAll(pageRequest);

		Stream<Product> products = page.get();
		products.forEach(System.out::println);

		int totalPages = page.getTotalPages();
		long totalElements = page.getTotalElements();
		System.out.printf("Total pages: %d\n", totalPages);
		System.out.printf("Total elements: %d\n", totalElements);
	}
}
