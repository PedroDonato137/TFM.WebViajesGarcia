package com.webTrail.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestClient;

@EntityScan(basePackages = "com.webTrail.model")
@EnableJpaRepositories(basePackages = "com.webTrail.repository")
@SpringBootApplication(scanBasePackages = {"com.webTrail.service", "com.webTrail.controller"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public RestClient getClient(){
		return RestClient.create();
	}

}
