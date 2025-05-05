package com.javatuz.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Accounts microservice REST API Documentation",
				description = "EazyBank Account microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Tokhir ASADOV",
						email = "guvalakat1603@gmail.com",
						url = "https://www.javatuz.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.javatuz.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "EazyBank Account microservice REST API Documentation",
				url = "https://www.javatuz.com/swagger-ui.html"
		)
)
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
