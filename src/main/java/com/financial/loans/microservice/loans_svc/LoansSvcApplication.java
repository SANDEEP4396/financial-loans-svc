package com.financial.loans.microservice.loans_svc;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@OpenAPIDefinition(
		info = @Info(
				title = "Loans microservice REST API Documentation",
				description = "Loans microservice REST API Documentation",
				version = "v1",
				contact = @Contact(
						name = "Test User",
						email = "test@LoansSvc.com",
						url = "https://www.LoansSvc.com"
				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.LoansSvc.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Loans microservice REST API Documentation",
				url = "https://www.LoansSvc.com/swagger-ui.html"
		)
)
public class LoansSvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoansSvcApplication.class, args);
	}

}
