package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Profile;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
	@EntityGraph(attributePaths = "user")
	List<Profile> findProfilesByLoyaltyPointsGreaterThanOrderByUserEmail(int loyaltyPoints);
}