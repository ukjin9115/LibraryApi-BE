package library.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SpringDocConfiguration {
	@Bean
	OpenAPI openAPI() {
		return new OpenAPI().info(
			new Info()
				.title("욱진'sLibrary REST API")
				.description("스프링부트 기반의 도서관 REST API 서비스")
				.version("v1.0")
				.license(
					new License()
						.name("Apache 2.0")
						.url("http://myapiserver.com"))

		);
	}
}
