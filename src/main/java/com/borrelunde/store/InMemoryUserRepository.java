package com.borrelunde.store;

import java.util.HashMap;
import java.util.Map;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class InMemoryUserRepository implements UserRepository {

	private final Map<String, User> mapOfEmailsAndUsers = new HashMap<>();

	@Override
	public void save(final User user) {
		mapOfEmailsAndUsers.put(user.getEmail(), user);
	}

	@Override
	public boolean exists(final User user) {
		return mapOfEmailsAndUsers.containsKey(user.getEmail());
	}
}
