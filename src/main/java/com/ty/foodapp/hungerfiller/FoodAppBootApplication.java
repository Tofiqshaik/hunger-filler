package com.ty.foodapp.hungerfiller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FoodAppBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(FoodAppBootApplication.class, args);
	}
	
	@Bean
	public Docket getDocket() {
		Contact contact = new Contact("Toufiq", "www.testyantra.com", "tofiqshaik1@gmail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo apiInfo = new ApiInfo("Hunger Filler", "Service to manage hunger", "SNAPSHOT 1.0", "www.testyantraglobal.com", contact, "Licence 12315", "www.testyantra.com", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.ty")).build().apiInfo(apiInfo).useDefaultResponseMessages(false);
	}
}
