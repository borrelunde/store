package com.borrelunde.store;

import org.springframework.beans.factory.annotation.Value;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
public class EmailNotificationService implements NotificationService {

	@Value("${email.host:localhost}")
	private String host;

	@Value("${email.port:25}")
	private int port;

	@Override
	public void send(final String message, final String recipientEmail) {
		System.out.printf("Sending email with message: %s to email: %s on host and port: %s:%d\n",
				message, recipientEmail, host, port);
	}
}
