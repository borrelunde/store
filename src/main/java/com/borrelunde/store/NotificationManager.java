package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Service
public class NotificationManager {

	private final NotificationService notificationService;

	public NotificationManager(@Qualifier("email") final NotificationService notificationService) {
		this.notificationService = notificationService;
	}

	public void sendNotification(final String message) {
		notificationService.send(message);
	}
}
