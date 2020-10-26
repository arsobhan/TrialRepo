package com.sample.review;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.sample.review.repository.ReviewRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@EnableJpaRepositories(basePackageClasses = ReviewRepository.class)
@SpringBootApplication
public class ReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReviewApplication.class, args);
	}

	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                                         
          .apis(RequestHandlerSelectors.basePackage("com.sample.review.controller"))
          .paths(PathSelectors.ant("/**/**")) 
          .build()
          .apiInfo(apiInfo());                                           
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Review API", 
          "Review Services", 
          "API TOS", 
          "Terms of service", 
          new Contact("Contact", "www.support.com", ""), 
          "License of API", "API license URL");
   } 
}
