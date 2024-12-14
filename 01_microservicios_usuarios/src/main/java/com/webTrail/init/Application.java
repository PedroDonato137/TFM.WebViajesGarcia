package com.webTrail.init;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan( basePackages = "com.webTrail.model") // Paquetes con entidades JPA
@EnableJpaRepositories(basePackages = "com.webTrail.repository") // Paquetes con interfaces JpaRepository
@SpringBootApplication(scanBasePackages = {"com.webTrail.service", "com.webTrail.controller"})
public class Application {

	public static void main(String[] args) {

		SpringApplication.run(Application.class, args);
	}

}
