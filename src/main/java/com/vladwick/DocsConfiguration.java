package com.vladwick;

import java.util.ArrayList;
import java.util.function.Predicate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class DocsConfiguration {
	
	public static final String VSystem_TAG = "VSystem";
	
	@Bean
    public Docket api() {
		Docket docket = new Docket(DocumentationType.SWAGGER_2);
		
		docket.select()
		//.apis(Predicate.not(RequestHandlerSelectors.basePackage("org.springframework.boot")))
		.paths(Predicate.not(PathSelectors.regex("/error")))
        .build();
		
		final Contact VSystem_CONTACT
	      = new Contact(
	      "",
	      "",
	      "");
		ApiInfo info = new ApiInfo("VSystem API", "Documentation for working with VSystem", "1.2", "urn:tos",
			      VSystem_CONTACT,
			      "Apache 2.0",
			      "http://www.apache.org/licenses/LICENSE-2.0",
			      new ArrayList<>());
		docket.apiInfo(info);
		return docket;
    }
}
