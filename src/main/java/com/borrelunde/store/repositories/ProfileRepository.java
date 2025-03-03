package com.borrelunde.store.repositories;

import com.borrelunde.store.entities.Profile;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<Profile, Long> {
	List<Profile> findProfilesByLoyaltyPointsGreaterThan(int loyaltyPoints);
}