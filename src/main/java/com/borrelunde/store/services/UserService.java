package com.borrelunde.store.services;

import com.borrelunde.store.entities.Address;
import com.borrelunde.store.entities.Profile;
import com.borrelunde.store.entities.User;
import com.borrelunde.store.repositories.AddressRepository;
import com.borrelunde.store.repositories.ProfileRepository;
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
	private final ProfileRepository profileRepository;
	private final AddressRepository addressRepository;
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

	@Transactional
	public void showRelatedEntities() {
		Profile profile = profileRepository.findById(2L).orElseThrow();
		System.out.printf("Profile bio: %s\n", profile.getBio());
		System.out.printf("Profile user name: %s\n", profile.getUser().getName());
	}

	public void fetchAddress() {
		addressRepository.findById(1L).orElseThrow();
	}

	public void persistRelated() {
		User user = User.builder()
				.name("John")
				.email("john@mail.com")
				.password("password")
				.build();

		Address address = Address.builder()
				.street("street")
				.city("city")
				.state("state")
				.zip("zip")
				.build();

		user.addAddress(address);

		userRepository.save(user);
	}

	@Transactional
	public void deleteRelated() {
		User user = userRepository.findById(3L).orElseThrow();
		Address address = user.getAddresses().getFirst();
		user.removeAddress(address);
		userRepository.save(user);
	}
}
