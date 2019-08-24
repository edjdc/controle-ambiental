package com.github.edjdc.ativos.config;

import static io.swagger.models.auth.In.HEADER;
import static java.util.Collections.singletonList;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class Swagger2Config {

	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.securitySchemes(singletonList(new ApiKey("JWT", AUTHORIZATION, HEADER.name())))
		        .securityContexts(singletonList(
		                SecurityContext.builder()
		                    .securityReferences(
		                        singletonList(SecurityReference.builder()
		                            .reference("JWT")
		                            .scopes(new AuthorizationScope[0])
		                            .build()
		                        )
		                    )
		                    .build())
		         )
		        .tags(new Tag("Ativos", "API Ativos"), new Tag("Manutencao Ativo", "API Manutencao Ativo"))
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.github.edjdc.ativos"))
				.paths(PathSelectors.any())
				.build();
	}
	
}
