package engineeringthesis.androidrestapi.config;


import java.util.Collections;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
class SwaggerConfig {

		@Bean
		public Docket get()
		{
			return new Docket(DocumentationType.SWAGGER_2)
					.select()
					.paths(PathSelectors.ant("/api/**"))
					.apis(RequestHandlerSelectors.basePackage("engineeringthesis.androidrestapi"))
					.build()
					.apiInfo(createApiInfo())
					.securitySchemes(Collections.singletonList(createSchema()))
					.securityContexts(Collections.singletonList(createContext()));
		}
		
		private ApiInfo createApiInfo()
		{
			return new ApiInfoBuilder()
	                .title("REST API Engineering Thesis")
	                .description("REST API Documentation used for mobile App project")
	                .contact(new Contact("Adam Zimny",
	                                     "https://github.com/R3venge1337?tab=repositories",
	                                     "adamczyk97@op.pl"))
	                .license("License name here")
	                .licenseUrl("URL to license")
	                .version("version 1")
	                .build();
			
		}
		
		private SecurityScheme createSchema() {
			
			return new ApiKey("apiKey", "Authorization", "header");
		}
		
		private SecurityContext createContext()
		{
			return SecurityContext.builder()
					.securityReferences(defaultAuth())
					.build();
		}
		
		private List<SecurityReference> defaultAuth() {
		        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
		        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
		        authorizationScopes[0] = authorizationScope;
		        return Collections.singletonList(new SecurityReference("apiKey", authorizationScopes));
		}


		
}
