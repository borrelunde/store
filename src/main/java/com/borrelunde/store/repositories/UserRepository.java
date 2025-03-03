package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
public interface UserRepository extends CrudRepository<User, Long> {
	@EntityGraph(attributePaths = {"tags", "addresses"})
	Optional<User> findByEmail(String email);

	@EntityGraph(attributePaths = "addresses")
	@Query("select u from User u")
	List<User> findAllWithAddresses();
}
