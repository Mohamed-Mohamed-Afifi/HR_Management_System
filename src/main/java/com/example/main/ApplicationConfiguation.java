package com.example.main;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@Configuration
public class ApplicationConfiguation {

	@Bean
	@Qualifier("firstOrder")
	public Orders orders() {
		return new Orders(15);
	}
	@Bean
//	@Profile("dev")
	@Qualifier("secondOrder")
	public Orders ordersTwo() {
		return new Orders();
	}
	
}
