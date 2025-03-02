package com.borrelunde.store.services;

import com.borrelunde.store.entities.User;
import com.borrelunde.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.02
 */
@AllArgsConstructor
@Service
public class UserService {

	private final UserRepository userRepository;
	private final EntityManager entityManager;

	@Transactional
	public void showEntityStates() {
		final User user = User.builder()
				.name("John")
				.email("john@mail.com")
				.password("password")
				.build();
		printEntityState(user);
		userRepository.save(user);
		printEntityState(user);
	}

	private void printEntityState(final User user) {
		if (entityManager.contains(user)) {
			System.out.println("Persistent");
		} else {
			System.out.println("Transient/Detached");
		}
	}
}
