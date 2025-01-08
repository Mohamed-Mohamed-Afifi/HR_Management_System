package com.example.main.testfeathers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Products {
	@GetMapping("/products")
	public String getProducts() {
		return "All products";
	}
}
