package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public interface UserRepository {
	void save(final User user);
	boolean exists(final User user);
}
