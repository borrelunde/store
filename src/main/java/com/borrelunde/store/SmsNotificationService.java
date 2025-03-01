package com.borrelunde.store;

import org.springframework.stereotype.Service;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Service("sms")
public class SmsNotificationService implements NotificationService {

	@Override
	public void send(final String message) {
		System.out.printf("Sending SMS: %s%n", message);
	}
}
