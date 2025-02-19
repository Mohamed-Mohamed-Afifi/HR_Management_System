package com.afify.hr_system.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
		info = @Info(
					contact = @Contact(
							email = "mohamed.org050@gmail.com",
							name = "Mohamed Afify",
							url = "https://mohamedafify-git-main-mohamedmohamedafifis-projects.vercel.app/"
							),
					description = "HR Mangement System",
					title = "HR Mangement System V1",
					termsOfService = "some of terms"
				),
		servers = {
				@Server(
							description = "Local dev",
							url="http://localhost:8080/"
						),
				@Server(
						description = "test server",
						url="http://localhost:8080/test"
					),
		},
		security = {
				@SecurityRequirement(
				name="bearerAuth"
				)
		}
		
		)
@SecurityScheme(
		name = "bearerAuth",
		type = SecuritySchemeType.HTTP,
		scheme = "bearer",
		bearerFormat = "JWT",
		description = "add token to connect to api"
		)
public class OpenApi {

}
