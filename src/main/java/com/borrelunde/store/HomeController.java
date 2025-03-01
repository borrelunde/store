package com.borrelunde.store;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author B. Lunde
 * @since 2025.03.01
 */
@Controller
public class HomeController {

	@RequestMapping("/")
	public String index() {
		return "index.html";
	}
}
