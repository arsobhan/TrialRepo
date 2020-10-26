package com.sample.moviereviewapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MovieReviewAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewAppApplication.class, args);
	}

}
