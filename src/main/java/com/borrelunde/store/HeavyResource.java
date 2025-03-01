package com.borrelunde.store;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Component
@Lazy
public class HeavyResource {
	public HeavyResource() {
		System.out.println("HeavyResource created");
	}
}
