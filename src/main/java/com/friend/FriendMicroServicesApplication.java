package com.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class FriendMicroServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendMicroServicesApplication.class, args);
	}
	
	@Bean
	  public  Docket   docket() {
		  ApiInfo  apiInfo = new ApiInfoBuilder().title("Friend MicoService REST DOCUMENTATION")
				  .description("Friend Rest Add and Getting Friend Contact operations").version("1.1")
				  .contact(new Contact("Rakesh", null, "rakeshsunkari95@gmail.com"))
				  .license("Sathya license").licenseUrl("http://www.sathyatech.com").build();
	  
		  return new Docket(DocumentationType.SWAGGER_2)
				  .select()
				  .apis(RequestHandlerSelectors.basePackage("com.friend.restcontroller"))
				  .paths(PathSelectors.any())
				  .build().apiInfo(apiInfo);
	  }
}
