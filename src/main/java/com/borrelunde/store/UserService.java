package com.borrelunde.store;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class UserService {

	private final UserRepository userRepository;
	private final NotificationService notificationService;

	public UserService(final UserRepository userRepository,
	                   final NotificationService notificationService) {
		this.userRepository = userRepository;
		this.notificationService = notificationService;
	}

	void registerUser(final User user) {
		if (userRepository.exists(user)) {
			System.out.printf("User with email %s already exists.\n", user.getEmail());
			return;
		}
		userRepository.save(user);
		notificationService.send("Registered!", user.getEmail());
	}
}
