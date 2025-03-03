package com.borrelunde.store.services;

import com.borrelunde.store.entities.Profile;
import com.borrelunde.store.entities.User;
import com.borrelunde.store.repositories.ProfileRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * For exercise 9.7.
 *
 * @author B. Lunde
 * @since 2025.03.03
 */
@Service
public class CustomQueriesService {

	private final ProfileRepository profileRepository;

	public CustomQueriesService(final ProfileRepository profileRepository) {
		this.profileRepository = profileRepository;
	}

	public void populateDatabaseWithUsersAndProfilesWithLoyaltyPoints() {
		User john = User.builder().name("John").email("john@mail.com").password("password").build();
		User jane = User.builder().name("Jane").email("jane@mail.com").password("password").build();
		User robert = User.builder().name("Robert").email("robert@mail.com").password("password").build();

		Profile johnProfile = Profile.builder().user(john).bio("John's biography").loyaltyPoints(5).build();
		Profile janeProfile = Profile.builder().user(jane).bio("Jane's biography").loyaltyPoints(10).build();
		Profile robertProfile = Profile.builder().user(robert).bio("Robert's biography").loyaltyPoints(20).build();

		profileRepository.saveAll(List.of(johnProfile, janeProfile, robertProfile));
	}

	@Transactional
	public void fetchProfilesWithMoreThanTwoLoyaltyPoints() {
		List<Profile> profiles = profileRepository.findProfilesByLoyaltyPointsGreaterThan(2);
		System.out.printf("Profiles with more than 2 loyalty points: %d\n", profiles.size());
		profiles.forEach(profile ->
				System.out.printf("- Profile ID: %d, user email: %s\n",
						profile.getId(),
						profile.getUser().getEmail()));
	}
}
