package com.sample.movielist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableEurekaClient
@SpringBootApplication
public class MovieListApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieListApplication.class, args);
	}

	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                                         
          .apis(RequestHandlerSelectors.basePackage("com.sample.movielist.controller"))
          .paths(PathSelectors.ant("/**/**")) 
          .build()
          .apiInfo(apiInfo());                                           
    }
	
    private ApiInfo apiInfo() {
        return new ApiInfo(
          "Movie Review API", 
          "Movie Review Services", 
          "API TOS", 
          "Terms of service", 
          new Contact("Contact", "www.support.com", ""), 
          "License of API", "API license URL");
   } 
}
