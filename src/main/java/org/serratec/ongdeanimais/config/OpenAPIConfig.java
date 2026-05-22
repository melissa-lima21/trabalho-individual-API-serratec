package org.serratec.ongdeanimais.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenAPIConfig {
	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title("API - ONG de Animais")
						.description("Sistema de ONG de animais.")
						.version("1.0.0")
						.contact(new Contact()
								.name("Melissa Lima da Silva")
								.url("https://github.com/melissa-lima21/trabalho-individual-API-serratec/tree/main")));
	}
}