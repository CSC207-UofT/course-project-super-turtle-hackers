package com.amigo.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.amigo.control", "com.amigo.course"})
@EntityScan(basePackages = {"com.amigo.course"})
@EnableJpaRepositories("com.amigo.course")
public class AmigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmigoApplication.class, args);
	}
}
