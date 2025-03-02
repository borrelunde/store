package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
public interface UserRepository extends CrudRepository<User, Long> {
}
